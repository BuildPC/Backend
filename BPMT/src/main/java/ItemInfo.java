
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denizcan
 */
public class ItemInfo extends javax.swing.JPanel {

    /**
     * Creates new form ItemInfo
     */
    public ItemInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemTopLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        ItemScrolpane3 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        AddItemButton = new javax.swing.JButton();
        MoreInfoButton = new javax.swing.JButton();
        realAddStock = new javax.swing.JTextField();
        realCurrentValue = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 0));
        setMaximumSize(new java.awt.Dimension(1095, 720));
        setMinimumSize(new java.awt.Dimension(1095, 720));

        ItemTopLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ItemTopLabel.setText("Items Manager");

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", ""},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Current Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ItemScrolpane3.setViewportView(ItemTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ItemScrolpane3, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ItemScrolpane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel2);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Add new Item : ");

        AddItemButton.setBackground(new java.awt.Color(255, 255, 255));
        AddItemButton.setText("+");
        AddItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemButtonActionPerformed(evt);
            }
        });

        MoreInfoButton.setText("More Info");
        MoreInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoreInfoButtonActionPerformed(evt);
            }
        });

        realAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realAddStockActionPerformed(evt);
            }
        });

        realCurrentValue.setText("add stock");
        realCurrentValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realCurrentValueActionPerformed(evt);
            }
        });

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddItemButton)
                .addGap(293, 293, 293))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(realCurrentValue)
                            .addComponent(MoreInfoButton)
                            .addComponent(realAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ItemTopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(MoreInfoButton)
                        .addGap(25, 25, 25)
                        .addComponent(realCurrentValue)
                        .addGap(18, 18, 18)
                        .addComponent(realAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RefreshButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(ItemTopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(AddItemButton))
                .addContainerGap(163, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MoreInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoreInfoButtonActionPerformed

        TableModel Table1 = ItemTable.getModel();
        int index1[] = ItemTable.getSelectedRows();

        Object[] row1 = new Object[3];
        ItemShow itemshow = new ItemShow();

        for(int i =0;i<index1.length;i++){
            row1[0]= Table1.getValueAt(index1[i],0);
            row1[1]= Table1.getValueAt(index1[i], 1);
            row1[2]= Table1.getValueAt(index1[i],2);

        }

        itemshow.setVisible(true);

        itemshow.ItemIdLabel.setText("Item ID : "+row1[0]);
        itemshow.ItemNameLabel.setText("Item name : "+row1[1]);
        itemshow.CurrentStockLabel.setText("Current Stock : "+row1[2]);
        SQLUtilities.getItemData(Frame.conn, row1[1].toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_MoreInfoButtonActionPerformed

    private void realAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realAddStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realAddStockActionPerformed

    private void realCurrentValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realCurrentValueActionPerformed

        TableModel Table1 = ItemTable.getModel();
        int index1[] = ItemTable.getSelectedRows();

        Object[] row1 = new Object[3];
        

        for(int i =0;i<index1.length;i++){
            row1[0]= Table1.getValueAt(index1[i],0);
            row1[1]= Table1.getValueAt(index1[i], 1);
            row1[2]= Table1.getValueAt(index1[i],2);

        }
        String tmp =""+row1[1];

        int currentStock;
        int addStock;
        addStock = (int)properStock(realAddStock.getText());
        currentStock=(int)row1[2];

        SQLUtilities.UpdateStock(tmp, addStock,currentStock, Frame.conn);
        try {
            Frame.conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        SQLUtilities.Update_tableItem(ItemTable);
        JOptionPane.showMessageDialog(this,"Stock updated");
        

    }//GEN-LAST:event_realCurrentValueActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed

        SQLUtilities.Update_tableItem(ItemTable);
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void AddItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemButtonActionPerformed
        // TODO add your handling code here:
         AddItem items = new AddItem();
         items.setVisible(true);
    }//GEN-LAST:event_AddItemButtonActionPerformed
protected static int properStock(String a){
         String replace = a.replace(".","");
         String replace1 = replace.replace(",", ".");
         String replace2 = replace1.replace("-","");
         int tmp = Integer.parseInt(replace2);
         return tmp;
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemButton;
    private javax.swing.JScrollPane ItemScrolpane3;
    protected static javax.swing.JTable ItemTable;
    private javax.swing.JLabel ItemTopLabel;
    private javax.swing.JButton MoreInfoButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField realAddStock;
    private javax.swing.JButton realCurrentValue;
    // End of variables declaration//GEN-END:variables
}