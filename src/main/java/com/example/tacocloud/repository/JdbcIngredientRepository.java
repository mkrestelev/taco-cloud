package com.example.tacocloud.repository;

import com.example.tacocloud.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class JdbcIngredientRepository implements IngredientRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public Iterable<Ingredient> findAll() {
    return jdbcTemplate.query("select id, name, type from Ingredient", this::mapToRowIngredient);
  }

  @Override
  public Ingredient findOne(String id) {
    return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?", this::mapToRowIngredient, id);
  }

  @Override
  public Ingredient save(Ingredient ingredient) {
    jdbcTemplate.update(
        "insert into Ingredient (id, name, type) values (?, ?, ?)",
        ingredient.getId(),
        ingredient.getName(),
        ingredient.getType().toString());
    return ingredient;
  }

  private Ingredient mapToRowIngredient(ResultSet resultSet, int row) throws SQLException {
    return new Ingredient(
        resultSet.getString("id"),
        resultSet.getString("name"),
        Ingredient.Type.valueOf(resultSet.getString("type")));
  }
  
}
