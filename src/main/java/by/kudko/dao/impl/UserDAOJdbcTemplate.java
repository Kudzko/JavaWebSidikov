package by.kudko.dao.impl;

import by.kudko.dao.IUserDAO;
import by.kudko.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
public class UserDAOJdbcTemplate implements IUserDAO {
    private JdbcTemplate jdbcTemplate;
    private final String FIND_ALL = "SELECT * FROM travel_agency.user;";
    private RowMapper<User> rowMapper = (resultSet, i) -> {
        return new User(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("nickname"));
    };

    public UserDAOJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

    @Override
    public Optional<User> find(User entity) {
        return Optional.empty();
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(FIND_ALL, rowMapper);
    }
}
