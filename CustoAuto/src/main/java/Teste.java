
import com.pos.dao.UsuarioDAO;
import com.pos.entity.TipoDespesa;
import com.pos.entity.Usuario;
import com.pos.factory.ConnectionFactory;
import com.pos.session.SessionSingleton;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antoniony.lima
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       /* Usuario user = new Usuario("antonionyceles", "654987");
//        SessionSingleton.setSessionUsuario(user);
        SessionSingleton.getAllKeys();*/
       
        System.out.println(TipoDespesa.valueOf("CO").nome());
    }

}
