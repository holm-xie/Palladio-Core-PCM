using System;

namespace Palladio.FiniteStateMachines {
	/// <summary>
	///	Represents the input of a FSM.
	///	
	///	author: JH
	/// </summary>
	public class Input {	

		/// <summary>
		/// Input instance indicating the end of a service effect specification.
		/// </summary>
		public static Input RETURN = new Input("return");

		/// <summary>
		/// String represinting the input.
		/// </summary>
		private object inputSymbol;


		/// <summary>
		/// The default constuctor.
		/// </summary>
		/// <param name="anInputSymbol">An Input object.</param>
		public Input(object anInputSymbol) {
			this.inputSymbol = anInputSymbol;
		}

		/// <summary>
		/// String represinting the input.
		/// </summary>
		public virtual object InputSymbol{
			get {return inputSymbol;}
		}

		/// <summary>
		/// Returns the Input as a string.
		/// </summary>
		/// <returns>The Input as string.</returns>
		public override String ToString() {
			return this.InputSymbol.ToString();
		}


		/// <summary>
		/// Compares this input to another object.
		/// </summary>
		/// <returns>true if both inputs are equal, false otherwise</returns>
		public override bool Equals(object obj) {
			if (obj is Input)
			{
				Input anInput = (Input)obj;
				return (anInput.InputSymbol == InputSymbol);
			}
			return false;
		}
		
//		public static bool operator == (Input one, Input two){
//			if ( (object)one != null ) {
//				return one.Equals(two);
//			} else if ( (object)two != null ) {
//				return false;
//			} else {
//				return true; // both null
//			}
//		}

//		public static bool operator != (Input one, Input two){
//			return !(one == two);
//		}

//		public static implicit operator string (Input anInput) {
//			return anInput.InputSymbol.ToString();
//		}
//
//		public static implicit operator Input (object aString) {
//			return new Input( aString );
//		}

		/// <summary>
		/// Delivers the Hashcode of the input
		/// </summary>
		/// <returns>The Hashcode in a <code>int</code>representation.</returns>
		public override int GetHashCode() {
			return InputSymbol.GetHashCode();
		}
	}
}
