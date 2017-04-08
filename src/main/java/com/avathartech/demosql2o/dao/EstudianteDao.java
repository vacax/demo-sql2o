package com.avathartech.demosql2o.dao;

import com.avathartech.demosql2o.encapsulacion.Estudiante;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

/**
 * Created by vacax on 07/04/17.
 */
public class EstudianteDao {

    private Sql2o sql2o;

    public EstudianteDao() {
        //subiendola en modo Embedded
        this.sql2o = new Sql2o("jdbc:h2:~/demosql2o", "sa", "");
        cargaDemo();
    }


    private void cargaDemo(){
        System.out.println("Cargando el demo...");
        if(getAllEstudiante().isEmpty()){
            crearDataDemo();
        }
    }

    public List<Estudiante> getAllEstudiante(){
        String sql="select * from estudiante";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Estudiante.class);
        }
    }

    public void crearDataDemo(){
        String sql = "insert into estudiante (matricula, nombre) values(:matricula,:nombre)";
        try (Connection con = sql2o.open()) {
            for(int i=0;i<100;i++) {
                con.createQuery(sql)
                        .addParameter("matricula", i)
                        .addParameter("nombre", "Estudiante "+i)
                        .executeUpdate();
            }
        }
    }
}
