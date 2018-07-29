package elpoeta.demopost.domain;

import java.util.List;

public class Autor {
	private Integer id;
	private String nombre;
	private List<Post> posts;
	
	public Autor() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", posts=" + posts + "]";
	}


	
}
