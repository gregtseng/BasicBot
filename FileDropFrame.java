/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.FinalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.dnd.DropTargetListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Danish
 */
public class FileDropFrame extends javax.swing.JFrame {
    
    private String path = "";
    private Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
    private Border normalBorder;
    private ImageIcon check = new ImageIcon("/Users/Danish/NetBeansProjects/Final Project/src/Images/CheckGreenEx.png");
    private ImageIcon x = new ImageIcon("/Users/Danish/NetBeansProjects/Final Project/src/Images/X.png");
    private Ascadac ascadac = new Ascadac();
    private message[] messages;
    
    public String getPath()
    {
        return path;
    }
    
    public message[] getMessages() 
    {
       return messages; 
    }
    
    

    /**
     * Creates new form FileDropFrame
     */
    public FileDropFrame() {
        initComponents();
        
        
            
      /*  iconPanel.setDropTarget(new DropTarget() {
            
        public void dragEnter (DropTargetDragEvent dtde) {
            //normal = iconPanel.getBorder();
            
            iconPanel.setBorder(redBorder);
        }
            
        public void dragOver (DropTargetDragEvent dtde) { 
            
           // normal = iconPanel.getBorder();
            
        }
        
        public void dragExit(DropTargetDragEvent dtde) {
           iconPanel.setBorder(normalBorder);
        }
        
        public synchronized void drop(DropTargetDropEvent dropEvent) {
            
            try {
                dropEvent.acceptDrop(DnDConstants.ACTION_COPY);
                List<File> droppedFiles = (List<File>) dropEvent.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                
                for (File file : droppedFiles) {
                    
                    path = file.getAbsolutePath();
                    
                }
                
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
       });
       
        
        */
        
        
        
        DropTarget target = new DropTarget(iconPanel,new  DropTargetListener() {

           
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
                 normalBorder = iconPanel.getBorder();
                 iconPanel.setBorder(blueBorder);
            }

            
            @Override
            public void dragOver(DropTargetDragEvent dtde) {
                 //Do nuttin
            }

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            
            public void dragExit(DropTargetEvent dte) {
                iconPanel.setBorder(normalBorder);
            }

            @Override
            public void drop(DropTargetDropEvent dtde) {
                iconPanel.setBorder(normalBorder); 
                try {
                dtde.acceptDrop(DnDConstants.ACTION_COPY);
                List<File> droppedFiles = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                
                for (File file : droppedFiles) {
                    
                    path = file.getAbsolutePath();
                    
                    
                    /*
                                        
                        if (!(path.split(".")[0]).equals("htm"))
                        {
                            jLabel2.setIcon(x);
                            
                        } else {
                            
                            jLabel2.setIcon(check);
                            
                        }
                    
                    */
                    
                    if (!path.equals(""))
                    {
                        jLabel2.setIcon(check);
                    } else {
                        jLabel2.setIcon(x);
                    }
                    
                    messages = ascadac.go(ascadac.parse(path));
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
            }
        });
    }
    
    public void dragOver(java.awt.dnd.DropTargetDragEvent e)
    {
        iconPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iconPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(131, 206, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("      Drag and drop the HTML file on to the icon below.");

        iconPanel.setBackground(new java.awt.Color(131, 206, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DnDIconV2Ex.png"))); // NOI18N

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iconPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iconPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        jLabel2.setIcon(new ImageIcon("/Users/Danish/NetBeansProjects/Final Project/src/Images/DnDIconV2Ex.png"));
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileDropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileDropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileDropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileDropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileDropFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel iconPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    String getFilePath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
