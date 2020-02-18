package controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IController<T> {
	T find(@PathVariable Long id);
	Long delete(@PathVariable Long id);
	T create(@RequestBody T obj);
	T update(@RequestBody T obj, @PathVariable Long id);
	List<T> list(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "delta", defaultValue = "30") int delta);
}
