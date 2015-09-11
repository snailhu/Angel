package angel.core.pojo2json.json;

public interface Renderer {

	public String render(Object object);

	public <T> String render(Object object, Class<T> t);
	

}
