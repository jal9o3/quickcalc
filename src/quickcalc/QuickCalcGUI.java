package quickcalc;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class QuickCalcGUI extends javax.swing.JFrame {

    QuickCalc quickCalc = new QuickCalc();

    class BackspaceAction extends AbstractAction {

        javax.swing.JLabel calculationLabel;

        BackspaceAction(javax.swing.JLabel calculationLabel) {
            this.calculationLabel = calculationLabel;

        }

        public void actionPerformed(ActionEvent e) {
            String reducedText;

            if (calculationLabel.getText().length() > 0) {
                reducedText = calculationLabel.getText().substring(
                        0, calculationLabel.getText().length() - 1);
                calculationLabel.setText(reducedText);
            }

        }
    }

    class ClearAction extends AbstractAction {

        javax.swing.JLabel ansLabel, calculationLabel;

        ClearAction(javax.swing.JLabel ansLabel, javax.swing.JLabel calculationLabel) {
            this.ansLabel = ansLabel;
            this.calculationLabel = calculationLabel;
        }

        public void actionPerformed(ActionEvent e) {
            ansLabel.setText("");
            calculationLabel.setText("");
        }

    }

    abstract class OperatorAction extends AbstractAction {

        javax.swing.JLabel calculationLabel;
        String operator;

        OperatorAction(javax.swing.JLabel calculationLabel, String operator) {
            this.calculationLabel = calculationLabel;
            this.operator = operator;

        }

        public void actionPerformed(ActionEvent e) {
            if (calculationLabel.getText().length() < 40) {
                calculationLabel.setText(calculationLabel.getText() + operator);
            }
        }
    }

    class PlusAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        PlusAction(javax.swing.JLabel calculationLabel) {
            super(calculationLabel, "+");
        }

    }

    class MinusAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        MinusAction(javax.swing.JLabel calculationLabel) {
            super(calculationLabel, "-");
        }

    }

    class TimesAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        TimesAction(javax.swing.JLabel calculationLabel) {
            super(calculationLabel, "*");
        }

    }

    class DivideAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        DivideAction(javax.swing.JLabel calculationLabel) {
            super(calculationLabel, "/");
        }

    }

    class OpParenthesisAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        OpParenthesisAction(javax.swing.JLabel calculationLabel) {
            super(calculationLabel, "(");
        }
    }

    class ClParenthesisAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        ClParenthesisAction(javax.swing.JLabel calculationLabel) {
            super(calculationLabel, ")");
        }
    }

    class EvaluateAction extends AbstractAction {

        javax.swing.JLabel calculationLabel, ansLabel;

        EvaluateAction(javax.swing.JLabel calculationLabel, javax.swing.JLabel ansLabel) {
            this.calculationLabel = calculationLabel;
            this.ansLabel = ansLabel;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                ansLabel.setText("= " + Double.toString(
                        quickCalc.calculate(calculationLabel.getText())));
            } catch (Exception ex) {
                Logger.getLogger(QuickCalcGUI.class.getName()).log(Level.SEVERE, null, ex);
                ansLabel.setText("ERROR");
            }
        }
    }

    class NumberAction extends OperatorAction {

        javax.swing.JLabel calculationLabel;

        NumberAction(javax.swing.JLabel calculationLabel, String number) {
            super(calculationLabel, number);
        }
    }

    /**
     * Creates new form QuickCalcGUI
     */
    public QuickCalcGUI() {
        initComponents();
        Action backspaceAction, clearAction, plusAction, minusAction, timesAction, divideAction, evaluateAction;
        Action oneAction, twoAction, threeAction, fourAction, fiveAction, sixAction, sevenAction, eightAction, nineAction, zeroAction;
        Action opParenthesisAction, clParenthesisAction;

        backspaceAction = new BackspaceAction(calculationLabel);
        clearAction = new ClearAction(ansLabel, calculationLabel);
        plusAction = new PlusAction(calculationLabel);
        minusAction = new MinusAction(calculationLabel);
        timesAction = new TimesAction(calculationLabel);
        divideAction = new DivideAction(calculationLabel);
        opParenthesisAction = new OpParenthesisAction(calculationLabel);
        clParenthesisAction = new ClParenthesisAction(calculationLabel);
        evaluateAction = new EvaluateAction(calculationLabel, ansLabel);

        oneAction = new NumberAction(calculationLabel, "1");
        twoAction = new NumberAction(calculationLabel, "2");
        threeAction = new NumberAction(calculationLabel, "3");
        fourAction = new NumberAction(calculationLabel, "4");
        fiveAction = new NumberAction(calculationLabel, "5");
        sixAction = new NumberAction(calculationLabel, "6");
        sevenAction = new NumberAction(calculationLabel, "7");
        eightAction = new NumberAction(calculationLabel, "8");
        nineAction = new NumberAction(calculationLabel, "9");
        zeroAction = new NumberAction(calculationLabel, "0");

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("BACK_SPACE"), "doBackspace");
        calculationLabel.getActionMap().put("doBackspace", backspaceAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("ctrl BACK_SPACE"), "doClear");
        calculationLabel.getActionMap().put("doClear", clearAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('+'), "doPlus");
        calculationLabel.getActionMap().put("doPlus", plusAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('-'), "doMinus");
        calculationLabel.getActionMap().put("doMinus", minusAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('*'), "doTimes");
        calculationLabel.getActionMap().put("doTimes", timesAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('/'), "doDivide");
        calculationLabel.getActionMap().put("doDivide", divideAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke(')'), "doClParen");
        calculationLabel.getActionMap().put("doClParen", clParenthesisAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('('), "doOpParen");
        calculationLabel.getActionMap().put("doOpParen", opParenthesisAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('='), "doEvaluate");
        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("ENTER"), "doEvaluate");
        calculationLabel.getActionMap().put("doEvaluate", evaluateAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('1'), "doOne");
        calculationLabel.getActionMap().put("doOne", oneAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('2'), "doTwo");
        calculationLabel.getActionMap().put("doTwo", twoAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('3'), "doThree");
        calculationLabel.getActionMap().put("doThree", threeAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('4'), "doFour");
        calculationLabel.getActionMap().put("doFour", fourAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('5'), "doFive");
        calculationLabel.getActionMap().put("doFive", fiveAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('6'), "doSix");
        calculationLabel.getActionMap().put("doSix", sixAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('7'), "doSeven");
        calculationLabel.getActionMap().put("doSeven", sevenAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('8'), "doEight");
        calculationLabel.getActionMap().put("doEight", eightAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('9'), "doNine");
        calculationLabel.getActionMap().put("doNine", nineAction);

        calculationLabel.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke('0'), "doZero");
        calculationLabel.getActionMap().put("doZero", zeroAction);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new javax.swing.JPanel();
        calculationLabel = new javax.swing.JLabel();
        ansLabel = new javax.swing.JLabel();
        componentPanel = new javax.swing.JPanel();
        sqrtButton = new javax.swing.JButton();
        sinButton = new javax.swing.JButton();
        cosButton = new javax.swing.JButton();
        tanButton = new javax.swing.JButton();
        ansButton = new javax.swing.JButton();
        logButton = new javax.swing.JButton();
        sysButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calculationLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        ansLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ansLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ansLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addComponent(calculationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ansLabel)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        sqrtButton.setText("sqrt");
        sqrtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqrtButtonActionPerformed(evt);
            }
        });

        sinButton.setText("sin");
        sinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinButtonActionPerformed(evt);
            }
        });

        cosButton.setText("cos");
        cosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cosButtonActionPerformed(evt);
            }
        });

        tanButton.setText("tan");
        tanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanButtonActionPerformed(evt);
            }
        });

        ansButton.setText("Ans");
        ansButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansButtonActionPerformed(evt);
            }
        });

        logButton.setText("log");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });

        sysButton.setText("sys");
        sysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sysButtonActionPerformed(evt);
            }
        });

        helpButton.setText("help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout componentPanelLayout = new javax.swing.GroupLayout(componentPanel);
        componentPanel.setLayout(componentPanelLayout);
        componentPanelLayout.setHorizontalGroup(
            componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(componentPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(componentPanelLayout.createSequentialGroup()
                        .addComponent(ansButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sysButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton))
                    .addGroup(componentPanelLayout.createSequentialGroup()
                        .addComponent(sqrtButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        componentPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ansButton, cosButton, helpButton, logButton, sinButton, sqrtButton, sysButton, tanButton});

        componentPanelLayout.setVerticalGroup(
            componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(componentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sqrtButton)
                    .addComponent(sinButton)
                    .addComponent(cosButton)
                    .addComponent(tanButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ansButton)
                    .addComponent(logButton)
                    .addComponent(sysButton)
                    .addComponent(helpButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(componentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(componentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sysButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpButtonActionPerformed

    private void sqrtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqrtButtonActionPerformed
        calculationLabel.setText(calculationLabel.getText() + "Math.sqrt(");
    }//GEN-LAST:event_sqrtButtonActionPerformed

    private void sinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinButtonActionPerformed
        calculationLabel.setText(calculationLabel.getText() + "Math.sin(");
    }//GEN-LAST:event_sinButtonActionPerformed

    private void cosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosButtonActionPerformed
        calculationLabel.setText(calculationLabel.getText() + "Math.cos(");
    }//GEN-LAST:event_cosButtonActionPerformed

    private void tanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanButtonActionPerformed
        calculationLabel.setText(calculationLabel.getText() + "Math.tan(");
    }//GEN-LAST:event_tanButtonActionPerformed

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        calculationLabel.setText(calculationLabel.getText() + "Math.log(");
    }//GEN-LAST:event_logButtonActionPerformed

    private void ansButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansButtonActionPerformed
        calculationLabel.setText(calculationLabel.getText() + Double.toString(quickCalc.getAns()));
    }//GEN-LAST:event_ansButtonActionPerformed

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
            java.util.logging.Logger.getLogger(QuickCalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuickCalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuickCalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuickCalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuickCalcGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ansButton;
    private javax.swing.JLabel ansLabel;
    private javax.swing.JLabel calculationLabel;
    private javax.swing.JPanel componentPanel;
    private javax.swing.JButton cosButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton logButton;
    private javax.swing.JButton sinButton;
    private javax.swing.JButton sqrtButton;
    private javax.swing.JButton sysButton;
    private javax.swing.JButton tanButton;
    // End of variables declaration//GEN-END:variables

}
