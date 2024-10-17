package br.com.yvestaba;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.reflections.Reflections;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintadorDePecas {
    public static void printSolucao(Tabuleiro tabuleiro, List<MapeadorDePosicao> posicoes) {
        for (var posicao : posicoes) {
            var coordenada = posicao.getCoordenadaAtual();
            for (int i = 0; i < tabuleiro.getTamanhoY(); i++) {
                for (int j = 0; j < tabuleiro.getTamanhoX(); j++) {
                    var peca = posicao.getPeca();
                    if (i >= coordenada.getY() && i < coordenada.getY() + peca.getTamanhoY()
                            && j >= coordenada.getX() && j < coordenada.getX() + peca.getTamanhoX()
                            && peca.get()[i - coordenada.getY()][j - coordenada.getX()]) {
                        System.out.print("o");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Reflections reflections = new Reflections("br.com.yvestaba");
        Set<Class<? extends Peca>> subclasses = reflections.getSubTypesOf(Peca.class);

        Map<String, boolean[][]> pecaPorNome = new HashMap<>();
        for (var classs : subclasses) {
            String nomePeca = classs.getSimpleName() + ":";
            try {
                Peca peca = (Peca) classs.getConstructors()[0].newInstance();
                pecaPorNome.put(nomePeca, peca.get());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        createPDFWithImageAndTitle("NomeDasPecas.pdf", pecaPorNome);

    }

    private static String createMatrixImage(boolean[][] matrix) {
        int cellSize = 10; // Size of each square
        int width = matrix[0].length * cellSize;
        int height = matrix.length * cellSize;

        // Create a BufferedImage
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Draw the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    g2d.setColor(Color.RED); // Color for true values
                } else {
                    g2d.setColor(new Color(0, 0, 0, 0)); // Transparent for false values
                }
                g2d.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

        // Dispose graphics context
        g2d.dispose();

        String filePath = "boolean_matrix.png";
        // Write the image to a file
        try {
            ImageIO.write(image, "PNG", new File(filePath));
            System.out.println("Matrix image saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static void createPDFWithImageAndTitle(String pdfFilePath, Map<String, boolean[][]> pecaPorNome) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            int margem = 50;
            float height = page.getMediaBox().getHeight() - 50;
            // Load the image

            // Create a content stream to draw on the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            for (var entry : pecaPorNome.entrySet()) {
                PDImageXObject pdImage = PDImageXObject.createFromFile(createMatrixImage(entry.getValue()), document);

                // Add the title text
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(margem, height); // Position the title
                contentStream.showText(entry.getKey());
                contentStream.endText();

                // Draw the image below the title
                height -= pdImage.getHeight() + 5;
                contentStream.drawImage(pdImage, margem, height, pdImage.getWidth(), pdImage.getHeight());
                height -= 30;
                if (height < 100) { // Account for margin and image height
                    // Close the content stream of the current page
                    contentStream.close();

                    // Create a new page and new content stream
                    page = new PDPage();
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);

                    height = page.getMediaBox().getHeight() - 50; // Reset available height
                }
            }

            contentStream.close();
            document.save(pdfFilePath);
            System.out.println("PDF saved to " + pdfFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
