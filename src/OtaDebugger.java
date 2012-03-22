/*
 * SerialGUI.java
 *
 * Created on November 5, 2007, 3:45 PM
 *
 * @author  Goldscott
 */

import gnu.io.*;
import java.io.*;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class OtaDebugger extends javax.swing.JFrame implements SerialPortEventListener {

    /**
     * Creates new form SerialGUI
     */
    public OtaDebugger() {
        try {
            String laf = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(laf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        getPorts();
        initComponents();
        displayFormat = RxFormat.ASCII;
        //Display some instructions upon opening
        textWin.append("##Select Port, Specify Baud Rate (default " + baudRate + "), Open Port.\n");
        //Create a file chooser
        fc = new JFileChooser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        rxformat = new javax.swing.ButtonGroup();
        scrollPane = new javax.swing.JScrollPane();
        textWin = new javax.swing.JTextArea();
        textbar = new javax.swing.JTextField();
        portBox = new javax.swing.JComboBox();
        baudField = new javax.swing.JTextField();
        baudButton = new javax.swing.JButton();
        portToggle = new javax.swing.JToggleButton();
        clearButton = new javax.swing.JButton();
        SendButton = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOG-a-TEC Debugger");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textWin.setColumns(20);
        textWin.setLineWrap(true);
        textWin.setRows(5);
        scrollPane.setViewportView(textWin);

        textbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textbarActionPerformed(evt);
            }
        });

        portBox.setModel(new javax.swing.DefaultComboBoxModel(portList));
        portBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portBoxActionPerformed(evt);
            }
        });

        baudField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baudFieldActionPerformed(evt);
            }
        });

        baudButton.setText("Set Baud");
        baudButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baudButtonActionPerformed(evt);
            }
        });

        portToggle.setText("Open Port");
        portToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portToggleActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Terminal");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        SendButton.setText("Send");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        firmwareLabel.setText("Firmware Location:");

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        uploadButton.setText("Upload Firmware");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        crcLabel.setText("Firmware CRC:");

        crcNumLabel.setText("     ");

        firmwareSizeLabel.setText("Firmware Size In Bytes:");

        firmwareSizeNumLabel.setText("     ");

        uriLabel.setText("URI:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1)
                    .add(scrollPane)
                    .add(layout.createSequentialGroup()
                        .add(textbar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(SendButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(baudField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(baudButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 181, Short.MAX_VALUE)
                        .add(clearButton))
                    .add(layout.createSequentialGroup()
                        .add(portBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(portToggle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(firmwareLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(firmwareTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(browseButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(firmwareSizeLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(firmwareSizeNumLabel))
                            .add(layout.createSequentialGroup()
                                .add(crcLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(crcNumLabel)))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(uriLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(uriTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(uploadButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(scrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 359, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(SendButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(portBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(portToggle))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(clearButton)
                    .add(baudField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(baudButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firmwareLabel)
                    .add(firmwareTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(browseButton))
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
                    .add(uploadButton)
                    .add(uriLabel)
                    .add(uriTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        //Send button is the same action as hitting Enter on the textbar
        textbarActionPerformed(evt);
    }//GEN-LAST:event_SendButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //remove all text from the window
        textWin.replaceRange("", 0, textWin.getText().length());
}//GEN-LAST:event_clearButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //when user closes, make sure to close open ports and open I/O streams       
        if (portIdentifier.isCurrentlyOwned()) { //if port open, close port
            portToggle.setText("Open Port");
            if (inputStream != null) //close input stream
            {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (outputStream != null) //close output stream
            {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            serialPort.removeEventListener();
            if (serialPort != null) {
                serialPort.close();
            }
            open = false;
            textWin.append("##Port " + portName + " is now closed.\n");
        }
    }//GEN-LAST:event_formWindowClosing

    private void baudButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baudButtonActionPerformed
        //only change baud when port is closed
        boolean reopen = false;
        if (portIdentifier.isCurrentlyOwned()) {//if port open, prompt user to close
            textWin.append("##Closing Port " + portName + ".\n");
            reopen = true;
            //JOptionPane.showMessageDialog(this, "Must Close Port First.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String newbaud = baudField.getText();//get text from user
        //do simple check to make sure baudrate is valid
        if (newbaud.equals("")) {
            textWin.append("##Must Enter Valid Baud Rate.\n");
            //JOptionPane.showMessageDialog(this, "Must Enter Valid Baud Rate.");
        } else {//convert string to int. when user re-opens port, it will be new baudrate
            baudRate = Integer.valueOf(newbaud).intValue();
            textWin.append("##Baud rate changed to " + baudRate + ".\n");
            if (reopen == true) {
                try {
                    connect(portName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textWin.append("##Opening Port: " + portName + ", Baud Rate: " + baudRate + ".\n");
            }
        }
    }//GEN-LAST:event_baudButtonActionPerformed

    private void portToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portToggleActionPerformed
        //only open valid port. portList[0]="select port" - not a valid port
        //if ((String)portBox.getSelectedItem() == portList[0]) {
        if (portBox.getSelectedItem().equals(portList[0])) {
            textWin.append("##Must Select Valid Port.\n");
            portToggle.setSelected(open);
            //JOptionPane.showMessageDialog(this, "Must Select Valid Port.", "Error", JOptionPane.ERROR_MESSAGE);
        } //if port open, close port & I/O streams
        else if (portIdentifier.isCurrentlyOwned()) {
            portToggle.setText("Open Port");
            //close input stream
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            //close output stream
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            //close serial port
            System.out.println("closing serial port.");
            serialPort.removeEventListener();
            if (serialPort != null) {
                serialPort.close();
            }
            System.out.println("closed serial port.");

            open = false;
            textWin.append("##Port " + portName + " is now closed.\n");
        } else {//else port is closed, so open it
            portToggle.setText("Close Port");
            portName = (String) portBox.getSelectedItem();
            textWin.append("##Opening Port: " + portName + ", Baud Rate: " + baudRate + ".\n");
            try {
                connect(portName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                serialPort.addEventListener(this);
            } catch (TooManyListenersException ex) {
                ex.printStackTrace();
            }
            serialPort.notifyOnDataAvailable(true);
            textWin.append("##Port opened.\n");
        }
        System.out.println("end of toggle function");
    }//GEN-LAST:event_portToggleActionPerformed

    //open serial port
    void connect(String portName) throws Exception {
        //make sure port is not currently in use
        portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            //create CommPort and identify available serial/parallel ports
            commPort = portIdentifier.open(this.getClass().getName(), 2000);
            serialPort = (SerialPort) commPort;//cast all to serial
            //set baudrate, 8N1 stopbits, no parity
            serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            //start I/O streams
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
            open = true;

        }
    }

    private void portBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portBoxActionPerformed
        if (open == true) { //if port open, make user close port before changing port
            textWin.append("##Must Close Port Before Changing Port.\n");
            //JOptionPane.showMessageDialog(this, "Must Close Port Before Changing Port.");
        } else {
            portName = (String) portBox.getSelectedItem();
            textWin.append("##Port Selected: " + portName + ", Baud Rate: " + baudRate + ".\n");
        }
    }//GEN-LAST:event_portBoxActionPerformed

    private void textbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textbarActionPerformed
        String text = textbar.getText();    //get text from field
        textWin.append("<<" + text + "\n");   //write text to terminal followed by new line
        textbar.selectAll();                //highlight text so it can be easily overwritten
        //if serial port open, write to serial port
        if (open == true) {
            text = text + "\r\n"; //append carriage return to text            
            try {
                outputStream.write(text.getBytes()); //write to serial port
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_textbarActionPerformed

    private void baudFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baudFieldActionPerformed
        //hitting "enter" does the same thing as pressing the "Set Baud" button
        baudButtonActionPerformed(evt);
    }//GEN-LAST:event_baudFieldActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        if (!firmwareUpload) {
            if (open) {
                if (file != null && uriTextField != null) {
                    firmware = new FileInPackets(file, inputStream, outputStream, textWin, uriTextField.getText());
                    new Thread(firmware).start();
                } else {
                    textWin.append("##No file selected.\n");
                }
            } else {
                textWin.append("##Serial port is not opened.\n");
            }
        } else {
            textWin.append("##Firmware upload already in process.\n");
        }
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        int returnVal = fc.showOpenDialog(OtaDebugger.this);
        file = fc.getSelectedFile();

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            firmwareTextField.setText(file.getAbsolutePath());

            try {
                FileInputStream fin = new FileInputStream(file);
                try {
                    Checksum checksum = new CRC32();
                    int b = 0;
                    while ((b = fin.read()) != -1) {
                        checksum.update(b);
                    }
                    firmwareSizeNumLabel.setText(Long.toString(file.length()));
                    crcNumLabel.setText(Long.toString(checksum.getValue()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    fin.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            firmwareTextField.setText("");
            firmwareSizeNumLabel.setText("");
            crcNumLabel.setText("");
            file = null;
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    /*
     * private void listPorts() { //display available ports to the terminal
     * Enumeration portEnum = CommPortIdentifier.getPortIdentifiers(); while (
     * portEnum.hasMoreElements() ) { portIdentifier = (CommPortIdentifier)
     * portEnum.nextElement(); textWin.append(portIdentifier.getName() + "\n");
     * } }
     */
    //run before initializing GUI
    //creates a string array of all the ports
    //to be displayed in dropdown box upon opening program

    private void getPorts() {
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        tempPortList = new String[MAX_PORTS]; //create array of 20 ports
        int numports = 0;
        int i;
        tempPortList[0] = "Select Port";
        //fill up a temporary list of length MAX_PORTS with the portnames
        while (portEnum.hasMoreElements()) {
            portIdentifier = (CommPortIdentifier) portEnum.nextElement();
            numports++;
            tempPortList[numports] = portIdentifier.getName();
        }
        //make the actual port list only as long as necessary
        portList = new String[numports];
        for (i = 0; i < numports; i++) {
            portList[i] = tempPortList[i];
        }
    }

    //serial event: when data is received from serial port
    //display the data on the terminal
    @Override
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.DATA_AVAILABLE:
                byte[] buffer = new byte[MAX_DATA];   //create a buffer (enlarge if buffer overflow occurs)
                int int16value;

                switch (displayFormat) {
                    case ASCII: {
                        try {   //read the input stream and store to buffer, count number of bytes read
                            int available = inputStream.available();
                            byte chunk[] = new byte[available];
                            inputStream.read(chunk, 0, available);

                            //add character to buffer
                            sharedBuffer = new ArrayBlockingQueue<Character>(available);
                            for (int i = 0; i < available; i++) {
                                sharedBuffer.add((char) chunk[i]);
                            }

                            // Displayed results are codepage dependent
                            textWin.append(new String(chunk).replace("\r\n", "\n"));

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                    case INT16: {
                        readall(inputStream, buffer, 2); //put two bytes in buffer
                        int16value = 256 * (int) buffer[1] + (int) buffer[0];
                        textWin.append(int16value + "\n");        //write to terminal
                        break;
                    }
                }
                //scroll terminal to bottom
                textWin.setCaretPosition(textWin.getText().length());
                break;
        }
    }

    //fill buffer with numBytes bytes from is
    public void readall(InputStream is, byte[] buffer, int numBytes) {
        int tempRead = 0;
        while (tempRead < numBytes) {
            try {
                tempRead = tempRead + is.read(buffer, tempRead, numBytes - tempRead);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OtaDebugger().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SendButton;
    private javax.swing.JButton baudButton;
    private javax.swing.JTextField baudField;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel crcLabel;
    private javax.swing.JLabel crcNumLabel;
    private javax.swing.JLabel firmwareLabel;
    private javax.swing.JLabel firmwareSizeLabel;
    private javax.swing.JLabel firmwareSizeNumLabel;
    private javax.swing.JTextField firmwareTextField;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox portBox;
    private javax.swing.JToggleButton portToggle;
    private javax.swing.ButtonGroup rxformat;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textWin;
    private javax.swing.JTextField textbar;
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
    private boolean open = false;
    private JFileChooser fc;
    private File file;
    private FileInPackets firmware;
    public static ArrayBlockingQueue<Character> sharedBuffer;
    public static boolean firmwareUpload = false;

    public enum RxFormat {

        ASCII, INT16;
    }
    private RxFormat displayFormat;
    //constants
    static final int MAX_PORTS = 20;    //maximum number of ports to look for
    static final int MAX_DATA = 64;//maximum length of serial data received
}
