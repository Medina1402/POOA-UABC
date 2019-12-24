package gui;

import data.Download;
import data.FileManager;
import data.Item;
import data.ItemList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Container extends JPanel {
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel defaultTableModel;

    private JTextField urlSpotify;
    private JLabel image;
    private Button update;
    private Button save;

    public Container(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setBackground(ColorFlat.ImperialPrime);
        setLayout(null);

        image = new JLabel();
        image.setBounds(25, 20, 100, 100);
        image.setIcon(FileManager.resizeImage("portada.png", image.getWidth(), image.getHeight()));
        add(image);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(FileManager.loadFileClass("portada.png")) {
                    image.setIcon(FileManager.resizeImage("portada.png", image.getWidth(), image.getHeight()));
                }
            }
        }, 0, 1000);

        save = new Button("Guardar");
        save.setToolTipText("Creara el archivo mediante serializacion");
        save.setBounds(image.getX() + image.getWidth() + 25, 70, getWidth() - (image.getX() + image.getWidth() + 50), 50);
        save.setBackground(ColorFlat.PastelRed);
        save.setColorOver(ColorFlat.PastelRed);
        save.setColorEntered(ColorFlat.ImperialPrime);
        add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataTable();
            }
        });

        urlSpotify = new JTextField("https://open.spotify.com/playlist/37i9dQZF1DWYN0zdqzbEwl");
        urlSpotify.setBounds(save.getX(), 25, save.getWidth(), 30);
        urlSpotify.setBackground(ColorFlat.ImperialPrime);
        urlSpotify.setForeground(ColorFlat.LightBlueBallerina);
        urlSpotify.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        urlSpotify.setBorder(new LineBorder(ColorFlat.LightBlueBallerina, 1));
        add(urlSpotify);

        update = new Button("Actualizar");
        update.setToolTipText("Descargara la informacion de internet y la reemplazara");
        update.setBounds(25, getHeight() - 75, getWidth() - 50, 50);
        update.setVisible(false);
        update.setBackground(ColorFlat.PastelRed);
        update.setColorOver(ColorFlat.PastelRed);
        update.setColorEntered(ColorFlat.ImperialPrime);
        add(update);
        if(Download.ComprobarConexion()) {
            update.setVisible(true);
            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int k=0; k<defaultTableModel.getRowCount(); k++) defaultTableModel.removeRow(k);
                    for(Item item: Download.get(urlSpotify.getText())) addElementList(item);
                }
            });
        }

        scrollPane = new JScrollPane();
        if(update.isVisible()) {
            scrollPane.setSize(getWidth() - 50, getHeight() - 250);
            scrollPane.setLocation(25, getHeight() - scrollPane.getHeight() - update.getHeight() - 50);
        } else {
            scrollPane.setSize(getWidth() - 50, getHeight() - 200);
            scrollPane.setLocation(25, getHeight() - scrollPane.getHeight() - 25);
        }
        scrollPane.setBackground(ColorFlat.ImperialPrime);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(ColorFlat.ImperialPrime);
        scrollPane.setViewportBorder(null);
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Item");
        defaultTableModel.addColumn("Artista");
        defaultTableModel.addColumn("Cancion");

        table = new JTable(defaultTableModel);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setBorder(null);
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setGridColor(ColorFlat.ImperialPrime);
        table.setBackground(ColorFlat.ImperialPrime);
        table.setForeground(ColorFlat.LightBlueBallerina);
        table.setSelectionBackground(ColorFlat.ImperialPrime);
        table.setSelectionForeground(ColorFlat.PastelRed);
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setBackground(ColorFlat.ImperialPrime);
        table.getTableHeader().setForeground(ColorFlat.LightBlueBallerina);
        table.getTableHeader().setBorder(null);
        table.getTableHeader().setFont(new Font("Sans-Serif", Font.BOLD, 15));
        table.setIntercellSpacing(new Dimension(0, 0));

        scrollPane.setViewportView(table);
        add(scrollPane);

        final ItemList lista = FileManager.loadClass(FileManager.PATHName);
        for(Item item: lista) addElementList(item);

        image.setIcon(FileManager.resizeImage("portada.png", image.getWidth(), image.getHeight()));
        image.repaint();
    }

    public void addElementList(Item item) {
        final String[] temp = {defaultTableModel.getRowCount()+1 + "", item.getAuthor(), item.getTitleSong()};
        defaultTableModel.insertRow(defaultTableModel.getRowCount(), temp);
    }

    public void saveDataTable() {
        ItemList temp = new ItemList();
        for(int k=0; k<defaultTableModel.getRowCount(); k++) {
            temp.add(new Item(defaultTableModel.getValueAt(k, 1).toString(), defaultTableModel.getValueAt(k, 2).toString(), Integer.parseInt(defaultTableModel.getValueAt(k, 0).toString())));
        }
        FileManager.Save(temp, FileManager.PATHName);
    }

    @Override
    public void paint(Graphics g) {
        if(urlSpotify.getText().contains("https://open.spotify.com/playlist")) {
            update.setEnabled(true);
            urlSpotify.setBorder(new LineBorder(ColorFlat.LightBlueBallerina, 1));
        } else {
            update.setEnabled(false);
            urlSpotify.setBorder(new LineBorder(ColorFlat.PastelRed, 1));
        }
        repaint();
        super.paint(g);
    }
}
