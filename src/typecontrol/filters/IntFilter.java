package typecontrol.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class IntFilter extends AbstractFilter {
    
    private int length = 0;

	private static final long serialVersionUID = 1L;
	protected Integer _max = 0; 
	
        public IntFilter (int length) {
            this.length = length;
        }
        
        
	public void setMax(Integer max) {
		_max = max;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		
           
            String text = getText(offset, str);
		
            
            if (text.length()>length){
			return;
		}
            
            if (!isValid(str, "0123456789", 0)) {
			return;
		}
		
		if (str.indexOf("-") != -1) {
	         if (str.indexOf("-") != 0 || offset != 0 ) {
	            return;
	       }
	    }
		
		if (!computeMax(new Double(_max), getText(offset, str))) {
			return;
		}
                
               
		
		super.insertString(offset, str, attr);
	}
}