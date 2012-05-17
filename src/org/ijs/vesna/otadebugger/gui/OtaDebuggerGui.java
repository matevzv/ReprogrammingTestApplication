package org.ijs.vesna.otadebugger.gui;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import gnu.io.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.ijs.vesna.otadebugger.communicator.Comunicator;

/**
 *
 * @author Matevz
 */
public class OtaDebuggerGui extends javax.swing.JFrame {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OtaDebuggerGui.class);

    /**
     * Creates new form
     */
    public OtaDebuggerGui() {
        try {
            String laf = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(laf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DOMConfigurator.configure("log4jConfig.xml");

        initComponents();
        //Display some instructions upon opening
        outputText("##Select the port to which the SSL server will listen.\n");
        comm = new Comunicator();
        fip = new FileInPackets();
        //Create a file chooser
        fc = new JFileChooser();
    }

    @Override
    public List<Image> getIconImages() {
        ArrayList<Image> imageList = new ArrayList<Image>();
        //imageList.add(new ImageIcon(System.getProperty("user.dir") + System.getProperty("file.separator") + "SensorLab-Logo.png").getImage());
        imageList.add(Toolkit.getDefaultToolkit().getImage(OtaDebuggerGui.class.getResource("../../logo/SensorLab-Logo.png")));
        return imageList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        communicationButtonGroup = new javax.swing.ButtonGroup();
        scrollPane = new javax.swing.JScrollPane();
        textWin = new javax.swing.JTextArea();
        getTextbar = new javax.swing.JTextField();
        portBox = new javax.swing.JComboBox();
        baudTextField = new javax.swing.JTextField();
        baudSetButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        sendGetButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        firmwareLabel = new javax.swing.JLabel();
        firmwareTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        crcLabel = new javax.swing.JLabel();
        crcNumLabel = new javax.swing.JLabel();
        firmwareSizeLabel = new javax.swing.JLabel();
        firmwareSizeNumLabel = new javax.swing.JLabel();
        uriLabel = new javax.swing.JLabel();
        uriTextField = new javax.swing.JTextField();
        postResourceTextField = new javax.swing.JTextField();
        postContentTextField = new javax.swing.JTextField();
        sendPostButton = new javax.swing.JButton();
        postResourceLabel = new javax.swing.JLabel();
        postContentLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        sslRadioButton = new javax.swing.JRadioButton();
        serialRadioButton = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        sslPortTextField = new javax.swing.JTextField();
        sslSetPortButton = new javax.swing.JButton();
        portToggleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VESNA Remote Debugger");
        setMinimumSize(new java.awt.Dimension(450, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textWin.setColumns(20);
        textWin.setEditable(false);
        textWin.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        textWin.setLineWrap(true);
        textWin.setRows(5);
        scrollPane.setViewportView(textWin);

        getTextbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTextbarActionPerformed(evt);
            }
        });

        portBox.setModel(new javax.swing.DefaultComboBoxModel());
        portBox.setEnabled(false);
        portBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portBoxActionPerformed(evt);
            }
        });

        baudTextField.setEnabled(false);
        baudTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baudTextFieldActionPerformed(evt);
            }
        });

        baudSetButton.setText("Set Baud");
        baudSetButton.setEnabled(false);
        baudSetButton.setMaximumSize(new java.awt.Dimension(101, 23));
        baudSetButton.setMinimumSize(new java.awt.Dimension(101, 23));
        baudSetButton.setPreferredSize(new java.awt.Dimension(110, 23));
        baudSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baudSetButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Terminal");
        clearButton.setPreferredSize(new java.awt.Dimension(110, 23));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        sendGetButton.setText("GET");
        sendGetButton.setPreferredSize(new java.awt.Dimension(110, 23));
        sendGetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendGetButtonActionPerformed(evt);
            }
        });

        firmwareLabel.setText("Firmware Location:");

        browseButton.setText("Browse");
        browseButton.setPreferredSize(new java.awt.Dimension(110, 23));
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        uploadButton.setText("Upload Firmware");
        uploadButton.setPreferredSize(new java.awt.Dimension(150, 23));
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        crcLabel.setText("Firmware CRC:");

        crcNumLabel.setText("     ");

        firmwareSizeLabel.setText("Firmware Size In Bytes:");

        firmwareSizeNumLabel.setText("     ");

        uriLabel.setText("Resource:");

        uriTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uriTextFieldActionPerformed(evt);
            }
        });

        postContentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postContentTextFieldActionPerformed(evt);
            }
        });

        sendPostButton.setText("POST");
        sendPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendPostButtonActionPerformed(evt);
            }
        });

        postResourceLabel.setText("Resource:");

        postContentLabel.setText("Content:");

        communicationButtonGroup.add(sslRadioButton);
        sslRadioButton.setSelected(true);
        sslRadioButton.setText("SSL Communication");
        sslRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sslRadioButtonActionPerformed(evt);
            }
        });

        communicationButtonGroup.add(serialRadioButton);
        serialRadioButton.setText("Serial Communication");
        serialRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialRadioButtonActionPerformed(evt);
            }
        });

        sslSetPortButton.setText("Open SSL Port");
        sslSetPortButton.setPreferredSize(new java.awt.Dimension(110, 23));

        portToggleButton.setText("Open Serial Port");
        portToggleButton.setEnabled(false);
        portToggleButton.setPreferredSize(new java.awt.Dimension(110, 23));
        portToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portToggleButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1)
                    .add(scrollPane)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(uriLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(uriTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(uploadButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(baudTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(baudSetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(clearButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(firmwareLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(firmwareTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(browseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(getTextbar)
                            .add(layout.createSequentialGroup()
                                .add(postResourceLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(postResourceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(postContentLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(postContentTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, sendPostButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, sendGetButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                    .add(jSeparator3)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(serialRadioButton)
                            .add(sslRadioButton)
                            .add(layout.createSequentialGroup()
                                .add(firmwareSizeLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(firmwareSizeNumLabel))
                            .add(layout.createSequentialGroup()
                                .add(crcLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(crcNumLabel))
                            .add(layout.createSequentialGroup()
                                .add(sslPortTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(sslSetPortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(portBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(portToggleButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {baudTextField, sslPortTextField}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {baudSetButton, browseButton, clearButton, portToggleButton, sendGetButton, sendPostButton, sslSetPortButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(scrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(getTextbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(sendGetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(sendPostButton)
                    .add(postContentTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(postResourceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(postResourceLabel)
                    .add(postContentLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sslRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(serialRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(sslPortTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(sslSetPortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(portBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(portToggleButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(clearButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(baudTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(baudSetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firmwareLabel)
                    .add(firmwareTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(browseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firmwareSizeLabel)
                    .add(firmwareSizeNumLabel))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(crcNumLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(crcLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(uploadButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(uriLabel)
                    .add(uriTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23))
        );

        layout.linkSize(new java.awt.Component[] {baudTextField, firmwareTextField, getTextbar, postContentTextField, postResourceTextField, sslPortTextField, uriTextField}, org.jdesktop.layout.GroupLayout.VERTICAL);

        layout.linkSize(new java.awt.Component[] {baudSetButton, browseButton, clearButton, portToggleButton, sendGetButton, sendPostButton, sslSetPortButton}, org.jdesktop.layout.GroupLayout.VERTICAL);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-609)/2, (screenSize.height-637)/2, 609, 637);
    }// </editor-fold>//GEN-END:initComponents

    private void sendGetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendGetButtonActionPerformed
        getMsg = getTextbar.getText();
        (new SendGet()).execute();
    }//GEN-LAST:event_sendGetButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //remove all text from the window
        textWin.replaceRange("", 0, textWin.getText().length());
}//GEN-LAST:event_clearButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (sslRadioButton.isSelected()) {
            // TODO close SSL Server
        } else {
            comm.closeSerialConnection();
        }
    }//GEN-LAST:event_formWindowClosing

    private void baudSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baudSetButtonActionPerformed
        String returnMsg = comm.setBaudRate(baudTextField.getText());
        outputText(returnMsg);
    }//GEN-LAST:event_baudSetButtonActionPerformed

    private void portBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portBoxActionPerformed
        String response = comm.setPortName((String) portBox.getSelectedItem());
        outputText(response);
    }//GEN-LAST:event_portBoxActionPerformed

    private void getTextbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTextbarActionPerformed
        sendGetButtonActionPerformed(evt);
    }//GEN-LAST:event_getTextbarActionPerformed

    private void baudTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baudTextFieldActionPerformed
        //hitting "enter" does the same thing as pressing the "Set Baud" button
        baudSetButtonActionPerformed(evt);
    }//GEN-LAST:event_baudTextFieldActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        int returnVal = fc.showOpenDialog(OtaDebuggerGui.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            firmwareTextField.setText("");
            firmwareSizeNumLabel.setText("  ");
            crcNumLabel.setText("  ");
            file = null;
            file = fc.getSelectedFile();
            if (file.length() < MB) {
                firmwareTextField.setText(file.getAbsolutePath());
                try {
                    FileInputStream fin = new FileInputStream(file);
                    try {
                        /*
                         * Checksum checksum = new CRC32(); int b = 0; while ((b
                         * = fin.read()) != -1) { checksum.update(b); }
                         * firmwareSizeNumLabel.setText(Long.toString(file.length()));
                         * crcNumLabel.setText(Long.toString(checksum.getValue()));
                         */
                        (new CrcCalculator()).execute();
                        firmwareSizeNumLabel.setText(Long.toString(file.length()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        fin.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                outputText("##Selected file size is too large.\n");
                outputText("##The maximum allowed size is one MB.\n");
                firmwareTextField.setText("");
                firmwareSizeNumLabel.setText("  ");
                crcNumLabel.setText("  ");
                file = null;
            }
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void uriTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uriTextFieldActionPerformed
        uploadButtonActionPerformed(evt);
    }//GEN-LAST:event_uriTextFieldActionPerformed

    private void serialRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialRadioButtonActionPerformed
        clearButtonActionPerformed(evt);
        outputText("##Select Port, Specify Baud Rate (default " + comm.getBaudRate() + "), Open Port.\n");
        // TODO Close SSL connection and get serial ports

        (new GetPorts()).execute();

        sslPortTextField.setEnabled(false);
        sslSetPortButton.setEnabled(false);

        portBox.setEnabled(true);
        portToggleButton.setEnabled(true);
        baudTextField.setEnabled(true);
        baudSetButton.setEnabled(true);
    }//GEN-LAST:event_serialRadioButtonActionPerformed

    private void sslRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sslRadioButtonActionPerformed
        comm.closeSerialConnection();
        clearButtonActionPerformed(evt);
        outputText("##Select the port to which the SSL server will listen.\n");

        portBox.setModel(new javax.swing.DefaultComboBoxModel());

        portBox.setEnabled(false);
        portToggleButton.setEnabled(false);
        portToggleButton.setText("Open Serial Port");
        baudTextField.setEnabled(false);
        baudSetButton.setEnabled(false);

        sslPortTextField.setEnabled(true);
        sslSetPortButton.setEnabled(true);
    }//GEN-LAST:event_sslRadioButtonActionPerformed

    private void portToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portToggleButtonActionPerformed
        String response = "";
        if (comm.isOpen()) {
            response = comm.closeSerialConnection();
            portToggleButton.setText("Open Serial Port");
        } else {
            response = comm.openSerialConnection();
            portToggleButton.setText("Close Serial Port");
        }
        outputText(response);
    }//GEN-LAST:event_portToggleButtonActionPerformed

    private void sendPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendPostButtonActionPerformed
        resource = postResourceTextField.getText();
        postMsg = postContentTextField.getText();
        (new SendPost()).execute();
    }//GEN-LAST:event_sendPostButtonActionPerformed

    private void postContentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postContentTextFieldActionPerformed
        sendPostButtonActionPerformed(evt);
    }//GEN-LAST:event_postContentTextFieldActionPerformed

    private void outputText(String str) {
        textWin.append(str);
        textWin.setCaretPosition(textWin.getText().length());
    }

    class CrcCalculator extends SwingWorker<Long, Object> {

        @Override
        protected Long doInBackground() throws Exception {
            FileInputStream fin = new FileInputStream(file);

            Checksum checksum = new CRC32();
            int b = 0;
            while ((b = fin.read()) != -1) {
                checksum.update(b);
            }

            return checksum.getValue();
        }

        @Override
        protected void done() {
            try {
                crcNumLabel.setText(Long.toString(get()));
            } catch (Exception ignore) {
            }
        }
    }

    class GetPorts extends SwingWorker<String[], Object> {

        @Override
        protected String[] doInBackground() throws Exception {
            String[] portList = comm.getPorts();

            return portList;
        }

        @Override
        protected void done() {
            try {
                portBox.setModel(new javax.swing.DefaultComboBoxModel(get()));
            } catch (Exception ignore) {
            }
        }
    }

    class SendGet extends SwingWorker<String, Object> {

        @Override
        protected String doInBackground() throws Exception {
            return comm.sendGet(getMsg);
        }

        @Override
        protected void done() {
            try {
                outputText(get());
            } catch (Exception ignore) {
            }
        }
    }

    class SendPost extends SwingWorker<String, Object> {

        @Override
        protected String doInBackground() throws Exception {
            return comm.sendPost(resource, postMsg);
        }

        @Override
        protected void done() {
            try {
                outputText(get());
            } catch (Exception ignore) {
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OtaDebuggerGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baudSetButton;
    private javax.swing.JTextField baudTextField;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton clearButton;
    private javax.swing.ButtonGroup communicationButtonGroup;
    private javax.swing.JLabel crcLabel;
    private javax.swing.JLabel crcNumLabel;
    private javax.swing.JLabel firmwareLabel;
    private javax.swing.JLabel firmwareSizeLabel;
    private javax.swing.JLabel firmwareSizeNumLabel;
    private javax.swing.JTextField firmwareTextField;
    private javax.swing.JTextField getTextbar;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox portBox;
    private javax.swing.JButton portToggleButton;
    private javax.swing.JLabel postContentLabel;
    private javax.swing.JTextField postContentTextField;
    private javax.swing.JLabel postResourceLabel;
    private javax.swing.JTextField postResourceTextField;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton sendGetButton;
    private javax.swing.JButton sendPostButton;
    private javax.swing.JRadioButton serialRadioButton;
    private javax.swing.JTextField sslPortTextField;
    private javax.swing.JRadioButton sslRadioButton;
    private javax.swing.JButton sslSetPortButton;
    private javax.swing.JTextArea textWin;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel uriLabel;
    private javax.swing.JTextField uriTextField;
    // End of variables declaration//GEN-END:variables
    private String[] tempPortList, portList; //list of ports for combobox dropdown
    private String portName;
    private CommPort commPort;
    private SerialPort serialPort;
    private CommPortIdentifier portIdentifier = null;
    private InputStream inputStream;
    private OutputStream outputStream;
    private int baudRate = 115200;
    private static boolean open = false;
    private JFileChooser fc;
    private File file;
    private FileInPackets fip;
    private Comunicator comm;
    private String getMsg;
    private String resource;
    private String postMsg;
    //constants
    static final int MAX_PORTS = 20;    //maximum number of ports to look for
    static final int MAX_DATA = 64;     //maximum length of serial data received
    static final long MB = 1048576;     //one Megabyte in Bytes
}
