package br.inpe.dpi.terrabrasilis.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vision")
public final class Vision implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Indexed(unique = true)
	private String name;
	private String description;
	private int stackOrder;
	private boolean enabled;
        private int maxLayersActive;

	@DBRef
	private List<Layer> layers;

	public Vision() { }

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

	public int getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(int stackOrder) {
		this.stackOrder = stackOrder;
	}

	public List<Layer> getLayers() {
		return layers == null ? Collections.emptyList() : Collections.unmodifiableList(this.layers);
	}

	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
        
        public int getMaxLayersActive(){
             return maxLayersActive;
        }
        
        public void setMaxLayersActive(int maxLayersActive){
            this.maxLayersActive = maxLayersActive;
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
		Vision vision = (Vision) other;
		return Objects.equals(id, vision.id) && Objects.equals(name, vision.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vision [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", stackOrder=").append(stackOrder).append(", enabled=").append(enabled)
				.append(", layers=")
				.append(layers).append("]");
		return builder.toString();
	}

}