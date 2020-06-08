package br.inpe.dpi.terrabrasilis.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.inpe.dpi.terrabrasilis.enuns.DatasourceType;

/**
 * 
 * @author jether
 *
 */
@Document(collection = "datasource")
public final class Datasource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Indexed(unique = true)
	private String name;
	private String description;
	private String host;
	private boolean enabled;
	@Indexed
	private DatasourceType type;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setType(DatasourceType type) {
		this.type = type;
	}

	public DatasourceType getType() {
		return this.type;
	}

	@Override
	public int hashCode() {		
		return Objects.hash(id, name, host);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Datasource tool = (Datasource) other;
		return Objects.equals(id, tool.id)
					&& Objects.equals(name, tool.name)
					&& Objects.equals(host, tool.host);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Datasource [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", host=").append(host)
				.append(", enabled=").append(enabled)
				.append(", type=").append(type).append("]");
		return builder.toString();
	}
}