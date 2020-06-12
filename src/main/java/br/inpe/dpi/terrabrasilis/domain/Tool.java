package br.inpe.dpi.terrabrasilis.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tool")
public final class Tool implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Indexed(unique = true)
	private String name;
	private String target;
        private String selector;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
        
        public String getSelector() {
            return selector;
        }
        
        public void setSelector(String selector){
            this.selector = selector;
        }

	@Override
	public int hashCode() {		
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Tool tool = (Tool) other;
		return Objects.equals(id, tool.id)
					&& Objects.equals(name, tool.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tool [id=").append(id).append(", name=").append(name)
				.append(", target=").append(target)
				.append("]");
		return builder.toString();
	}	
}