package com.pack.dao;

import java.sql.SQLException;
import java.util.List;

import com.pack.model.Todo;

public interface TodoDao {

	void insertTodo(Todo todo) throws SQLException;

	Todo selectTodo(long todoId);

	List<Todo> selectAllTodos();

	boolean deleteTodo(int id) throws SQLException;

	void updateTodo(Todo todo) throws SQLException;

}