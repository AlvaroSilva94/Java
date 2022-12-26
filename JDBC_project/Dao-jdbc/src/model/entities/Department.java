package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable{


	private static final long serialVersionUID = 1L;
		private Integer id;
		private String name;
		
		public Department() {
			
		}

		public Department(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//HashCode and equals is so my elements can be compared by
		//content and not by pointer reference
		
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Department other = (Department) obj;
			return Objects.equals(id, other.id);
		}

		//toString is so it easier to print the object values when testing
		@Override
		public String toString() {
			return "Department [id=" + id + ", name=" + name + "]";
		}
		
		//So my objects can be transformed into byte sequence (ex: to save to file)
		
}
