package src.net.codejava;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFPanel extends JPanel {

    private PDFRenderer renderer;
    private int currentPage = 0;

    public PDFPanel(PDFRenderer renderer) {
        this.renderer = renderer;
        setPreferredSize(new Dimension(800, 1000));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = renderer.renderImage(currentPage);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}