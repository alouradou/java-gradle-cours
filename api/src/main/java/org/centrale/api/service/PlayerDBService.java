package org.centrale.api.service;

import javax.sql.DataSource;
import org.centrale.domain.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PlayerDBService {

    final DataSource dataSource;

    public PlayerDBService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Player getPlayerById(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("SELECT * from players where id = ?",
                (rs, rowNum) -> new Player(rs.getInt("id"), rs.getString("name")), id);
    }


}
