package app2;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
public class cityCrawler extends javax.swing.JFrame
{
        public static String[][]a;
        public static String category="";
	public static String city="";
	public static String lon="";
	public static String lat="";
	public static String dia="";
	public void MyGETRequest1() throws IOException 
	{
	    URL urlForGetRequest = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&APPID=874f47a9ffe5635ee597c21bfad2e0e4");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        String response ="";
	        while ((readLine = in .readLine())!= null) 
	        {
	            response+=readLine;
	        }
	        JSONParser parse = new JSONParser(); 
	        try
	        {
	        	org.json.simple.JSONObject jobj = (org.json.simple.JSONObject)parse.parse(response); 
	        	String s="";
	        	s+=jobj.get("coord");
	        	String []a=s.split("\"");
	        	lon=a[2].substring(1,a[2].length()-1);
	        	lat=a[4].substring(1,a[4].length()-1);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        in .close();
	    } else {
	        System.out.println("Please enter a valid city name");
	    }
	}
	public void MyGETRequest() throws IOException {
            
	    URL urlForGetRequest = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lon+"&radius="+dia+"&type="+category+"&key=AIzaSyA7egNi5VZq9FnTuD-XFvRcZcYFqmsCNJE");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
	    String response ="";
	    while ((readLine = in .readLine())!= null) 
	    {
	            response+=readLine;
	    }
	        
	        JSONParser parse = new JSONParser(); 
	        try
	        {
	        	org.json.simple.JSONObject jobj = (org.json.simple.JSONObject)parse.parse(response); 
	        	JSONArray jsonarr_1 = (JSONArray) jobj.get("results"); 
                        a=new String[jsonarr_1.size()][jsonarr_1.size()];
	        	for(int i=0;i<jsonarr_1.size();i++)
	        	{
	        	org.json.simple.JSONObject jsonobj_1 = (org.json.simple.JSONObject)jsonarr_1.get(i);
                        String vic=(String)jsonobj_1.get("vicinity");
                        String name=(String)jsonobj_1.get("name");
	        	//System.out.println("Icon:" +jsonobj_1.get("icon"));
	        	//System.out.println("Name " +jsonobj_1.get("name"));
	        	//System.out.println("Full Address "+jsonobj_1.get("vicinity"));
	        	//System.out.println();
                        a[i][1]=vic;
                        a[i][0]=name;
	        	}
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        in .close();
	    } else {
	        System.out.println("Sorry No Data Found.");
	    }
	}
    public cityCrawler() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        city_name = new javax.swing.JTextField();
        school = new javax.swing.JRadioButton();
        hospital = new javax.swing.JRadioButton();
        bank = new javax.swing.JRadioButton();
        atm = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        diameter = new javax.swing.JTextField();
        college = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("City Crawler");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Enter the City");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Explore");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("   Select Type");

        city_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                city_nameActionPerformed(evt);
            }
        });

        buttonGroup2.add(school);
        school.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 14)); // NOI18N
        school.setText("Schools");

        buttonGroup2.add(hospital);
        hospital.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 14)); // NOI18N
        hospital.setText("Hospitals");

        buttonGroup2.add(bank);
        bank.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 14)); // NOI18N
        bank.setText("Banks");
        bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankActionPerformed(evt);
            }
        });

        buttonGroup2.add(atm);
        atm.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 14)); // NOI18N
        atm.setText("Atm's");
        atm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atmActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Enter the diameter of Area");

        diameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diameterActionPerformed(evt);
            }
        });

        buttonGroup2.add(college);
        college.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 14)); // NOI18N
        college.setText("Colleges");
        college.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(city_name, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(diameter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(school, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hospital, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bank)
                        .addGap(30, 30, 30)
                        .addComponent(atm)
                        .addGap(18, 18, 18)
                        .addComponent(college)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(city_name)
                        .addGap(3, 3, 3)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diameter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(school)
                    .addComponent(hospital)
                    .addComponent(bank)
                    .addComponent(atm)
                    .addComponent(college))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            city=city_name.getText();
            dia=diameter.getText();
            if(city.length()!=0&&dia.length()!=0&&((atm.isSelected()==true)||(college.isSelected()==true)||(bank.isSelected()==true)||(school.isSelected()==true)||(hospital.isSelected()==true)))
            {
               if(atm.isSelected()==true)
               {
                   category="atm";
               }
               else if(bank.isSelected()==true)
               {
                   category="bank";
               }
               else if(hospital.isSelected()==true)
               {
                   category="hospital";
               }
               else if(school.isSelected()==true)
               {
                   category="school";
               }
               else
               {
                   category="university";
               }
               this.setVisible(false);
               cityCrawler  t=new cityCrawler();
               t.MyGETRequest1();
               t.MyGETRequest();
               if(a.length==0)
               {
                   System.out.println("Sorry No Results Found!");
               }
               else
               {
                new data(a);
               }
            }
            else
            {
                if(city.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please enter the city");
                }
                else if(dia.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please enter the diameter of the area");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please select type");
                }
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bankActionPerformed

    private void atmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atmActionPerformed

    private void city_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_city_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_city_nameActionPerformed

    private void diameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diameterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diameterActionPerformed

    private void collegeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeActionPerformed

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
            java.util.logging.Logger.getLogger(cityCrawler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cityCrawler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cityCrawler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cityCrawler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cityCrawler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton atm;
    private javax.swing.JRadioButton bank;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField city_name;
    private javax.swing.JRadioButton college;
    private javax.swing.JTextField diameter;
    private javax.swing.JRadioButton hospital;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton school;
    // End of variables declaration//GEN-END:variables
}
