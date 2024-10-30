package ApplicationDemo.demo.repo;

import ApplicationDemo.demo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

@Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    public Alien save(Alien alien){

        String sql = "insert into alien (id, name, tech) values (?, ?, ?)";
        template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        return alien;
    }

    public Alien update(int id, Alien alien) {
        String updateSql = "UPDATE alien SET name = ? WHERE id = ?;";
        template.update(updateSql, alien.getName(), id);
        return alien;
    }

    public List<Alien> findAll() {
        String sql = "SELECT * FROM alien";

        RowMapper<Alien> mapper = (rs, rowNum) -> {
            Alien a = new Alien();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setTech(rs.getString("tech"));
            return a;
        };

        return template.query(sql, mapper);
    }

    public Alien findById(int id) {
        String sql = "SELECT * FROM alien WHERE id = ?";
        RowMapper<Alien> mapper = (rs, rowNum) -> {
            Alien a = new Alien();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setTech(rs.getString("tech"));
            return a;
        };

        return template.queryForObject(sql, new Object[]{id}, mapper);
    }

    public Alien
    deleteBy(int id, Alien alien){
        String Ssql = "DELETE FROM alien WHERE id = ?";
        template.update(Ssql, id);
        return alien;
    }
}
