package br.inpe.dpi.terrabrasilis.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author jether.rodrigues
 *
 */
@Document(collection = "layer")
public class Layer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String title;
	private String description;
	private String workspace;
	private int stackOrder;
	private double opacity;
	@Indexed
	private boolean baselayer;
	private boolean active;
	private boolean enabled;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime date;
        
        private String metadataId;
        private String downloadId;

	@DBRef
	@Indexed
	private Datasource datasource;
	@DBRef
	private List<Tool> tools;
	@DBRef
	private List<Subdomain> subdomains;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public int getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(int stackOrder) {
		this.stackOrder = stackOrder;
	}

	public double getOpacity() {
		return opacity;
	}

	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}

	public boolean isBaselayer() {
		return baselayer;
	}

	public void setBaselayer(boolean baselayer) {
		this.baselayer = baselayer;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
        
        public LocalDateTime getDate() {
            return date;
	}

	public void setDate(LocalDateTime date) {
            this.date = date;
	}

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

	public List<Subdomain> getSubdomains() {
		return this.subdomains == null ? Collections.emptyList() : Collections.unmodifiableList(this.subdomains);
	}

	public void setSubdomains(List<Subdomain> subdomains) {
		this.subdomains = subdomains;
	}

	public List<Tool> getTools() {
		return this.tools == null ? Collections.emptyList() : Collections.unmodifiableList(this.tools);
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}
        
        public String getDownloadId() {
            return downloadId;
        }

        public void setDownloadId(String downloadId) {
            this.downloadId = downloadId;
        }
        
        public String getMetadataId() {
            return metadataId;
        }

        public void setMetadataId(String metadataId) {
            this.metadataId = metadataId;
        }

	@Override
	public int hashCode() {
		return Objects.hash(datasource, id, name, workspace);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Layer other = (Layer) obj;
		return Objects.equals(datasource, other.datasource)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(workspace, other.workspace);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Layer [id=").append(id).append(", name=").append(name).append(", title=").append(title)
				.append(", description=").append(description)
				.append(", workspace=").append(workspace)
				.append(", stackOrder=").append(stackOrder).append(", opacity=").append(opacity).append(", baselayer=")
				.append(baselayer).append(", active=").append(active).append(", enabled=").append(enabled)
				.append(", datasource=").append(datasource).append(", tools=")
				.append(tools).append(", subdomains=").append(subdomains)
				.append("]");
		return builder.toString();
	}
}