package eventSystem;

import java.util.ArrayList;
import java.util.List;

public class Registry<E> {
	
	
		
		private List<E> regList;
		
		
		
		public Registry() {
		
		this.setRegList(new ArrayList<E>());
		
	}

		public List<E> getRegList() {
			return regList;
		}

		public void setRegList(List<E> regList) {
			this.regList = regList;
		}

}
