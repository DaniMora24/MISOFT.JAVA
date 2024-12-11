/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;


import ModelDAO.EnvioDAO;
import Model.Envio;

import java.sql.SQLException;
import java.util.List;

public class EnvioService {
    private EnvioDAO envioDAO;

    public EnvioService() {
        envioDAO = new EnvioDAO();
    }

    public List<Envio> listarEnvios() throws SQLException {
        return envioDAO.listarEnvios();
    }

    public void crearEnvio(Envio envio) throws SQLException {
        envioDAO.crearEnvio(envio);
    }

    public Envio obtenerEnvio(String numeroEnvio) throws SQLException {
        return envioDAO.obtenerEnvio(numeroEnvio);
    }

    public void actualizarEnvio(Envio envio) throws SQLException {
        envioDAO.actualizarEnvio(envio);
    }
}
