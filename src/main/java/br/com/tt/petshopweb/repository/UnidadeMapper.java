package br.com.tt.petshopweb.repository;

import br.com.tt.petshopweb.model.Unidade;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnidadeMapper implements RowMapper<Unidade> {
    @Override
    public Unidade mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Unidade(rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("endereco"));
    }
}
