package fr.alteca.github.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Branche {

	private String name;
	private Commit commit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Commit getCommit() {
		return commit;
	}

	public void setCommit(Commit commit) {
		this.commit = commit;
	}

	@Override
	public String toString() {
		return "Branche [name=" + name + ", commit=" + commit + "]";
	}
}
