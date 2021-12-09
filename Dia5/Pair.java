
public class Pair<O,E> {


	private E right;
	private O left;

	public Pair(O left,E right){
		this.left = left;
		this.right= right;
		

	}

	public E getRight() {
		return right;
	}

	public void setRight(E right) {
		this.right = right;
	}

	public O getLeft() {
		return left;
	}

	public void setLeft(O left) {
		this.left = left;
	}

	@Override
	public String toString() {
		String aux="";
		if(this.getRight()!=null) {
			O t = this.getLeft();
			if( t instanceof Integer) {
				Integer value = (Integer)this.getLeft();
				if(value==1) {
					aux= "\""+this.getRight().toString()+"\"";
				}else {
					aux= this.getRight().toString();
				}
			}
		}				
		return "<" + this.getLeft() + " , " + aux + " >";
	}

	

}
