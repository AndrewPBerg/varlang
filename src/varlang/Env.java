package varlang;

/**
 * Representation of an environment, which maps variables to values.
 * 
 * @author hridesh
 *
 */
public interface Env {
	Value get (String search_var);

	@SuppressWarnings("serial")
	static public class LookupException extends RuntimeException {
		LookupException(String message){
			super(message);
		}
	}
	
	static public class EmptyEnv implements Env {

		public Value get (String search_var) {
			// Default values for the EmptyEnv :: all envs will have these values!
			// test cases are 
			switch (search_var) {
				case "i":
					return new Value.NumVal(1);
				case "ii":
					return new Value.NumVal(2);
				case "iii":
					return new Value.NumVal(3);
				case "iv":
					return new Value.NumVal(4);
				case "v":
					return new Value.NumVal(5);
				case "vi":
					return new Value.NumVal(6);
				case "vii":
					return new Value.NumVal(7);
				case "viii":
					return new Value.NumVal(8);
				case "ix":
					return new Value.NumVal(9);
				case "x":
					return new Value.NumVal(10);
			}
			throw new LookupException("No binding found for name: " + search_var);
		}
	}
	
	static public class ExtendEnv implements Env {
		private Env _saved_env; 
		private String _var; 
		private Value _val; 
		public ExtendEnv(Env saved_env, String var, Value val){
			_saved_env = saved_env;
			_var = var;
			_val = val;
		}
		public Value get (String search_var) {

			if (search_var.equals(_var))
				return _val;
			return _saved_env.get(search_var);
		}
	}
	
}
