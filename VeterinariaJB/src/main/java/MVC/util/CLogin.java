package MVC.util;

import MVC.vista.vistaAdmin;
import MVC.vista.vistaOwner;
import MVC.vista.vistaRecepcionist;
import MVC.vista.vistaVeterinary;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CLogin {

    public void userValidate(JTextField user, JPasswordField pass) {
        try{
            ResultSet rs = null;
            PreparedStatement ps = null;

            MVC.util.DatabaseConnection Connect = new MVC.util.DatabaseConnection();
            String query = "select * from login where user = ? and password = ?";

            ps=Connect.getConnection().prepareStatement(query);

            String password = String.valueOf(pass.getPassword());

            ps.setString(1, user.getText());
            ps.setString(2, password);

            
            rs = ps.executeQuery();
            
            System.out.println(rs.toString());
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,"The user is valid");
                int rol = rs.getInt("role_id");
                switch(rol){
                    case 1:
                        vistaAdmin vA = new vistaAdmin();
                        vA.setVisible(true);;
                        break;
                        
                    case 2: 
                        vistaRecepcionist vR = new vistaRecepcionist();
                        vR.setVisible(true);;
                        break;
                    
                    case 3: 
                        vistaVeterinary vV = new vistaVeterinary();
                        vV.setVisible(true);
                        break;
                        
                    case 4:                      
                        vistaOwner vO = new vistaOwner();
                        vO.setVisible(true);   
                        break;
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"The user is not valid");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

}
