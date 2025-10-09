import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CashRegister extends JComponent{
    private JFrame CashRegisterFrame;
    private JPanel UPCDisplay;
    private JTable ProductTable;
    private DefaultTableModel tableModel;
    private double subtotal = 0.0;
    private JLabel subtotalLabel;

    // Hard coded data values, ideally would retrieve from DB
    private int code = 12345;
    private String productName = "Coffee";
    private double productPrice = 8.32;
    // second product
    private int code2 = 67890;
    private String productName2 = "Muffin";
    private double productPrice2 = 2.50;

    

    public CashRegister() {
        CashRegisterFrame = new JFrame("Cash Register");
        CashRegisterFrame.getContentPane().setLayout(new BorderLayout());
        CashRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CashRegisterFrame.setLocation(1200, 200);
        CashRegisterFrame.setVisible(true);

        UPCDisplay = new JPanel();
        UPCDisplay.setLayout(new BorderLayout());

        String[] columnNames = {"UPC Code", "Product Name", "Product Price"};
        tableModel = new DefaultTableModel(columnNames, 0);

        ProductTable = new JTable(tableModel);
        UPCDisplay.add(new JScrollPane(ProductTable), BorderLayout.CENTER);

        // Subtotal display at the bottom
        subtotalLabel = new JLabel("Subtotal: $0.00");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(subtotalLabel);

        CashRegisterFrame.getContentPane().add(UPCDisplay, BorderLayout.CENTER);
        CashRegisterFrame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        CashRegisterFrame.pack();
    }

    public void onScan(){
        addProductRow(code, productName, productPrice);
    }

    // helper to add a product row and update subtotal
    private void addProductRow(int upc, String name, double price){
        Object[] rowData = {upc, name, price};
        tableModel.addRow(rowData);
        // update subtotal
        subtotal += price;
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
    }

    // handle scanning with a UPC code provided
    public void onScan(int upc){
        if(upc == code){
            onScan(); // reuse existing behavior for the first product
        } else if(upc == code2){
            addProductRow(code2, productName2, productPrice2);
        } else {
            // Unknown UPC: show a simple dialog and ignore
            JOptionPane.showMessageDialog(CashRegisterFrame, "UPC not found: " + upc, "Unknown UPC", JOptionPane.WARNING_MESSAGE);
        }
    }

}


