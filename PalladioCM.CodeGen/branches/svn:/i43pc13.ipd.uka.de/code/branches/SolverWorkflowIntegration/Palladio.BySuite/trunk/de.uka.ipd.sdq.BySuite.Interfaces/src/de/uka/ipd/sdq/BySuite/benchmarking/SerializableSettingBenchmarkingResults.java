package de.uka.ipd.sdq.BySuite.benchmarking;

import java.util.TreeMap;

import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchMethodSignatureException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchOpcodeException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchScenarioException;

/**
 * @author Michael Kuperberg, mkuper@ipd.uka.de 
 * TODO rename methods to match the
 *         int-String problem of methods vs. opcodes 
 * TODO there may exist
 *         several Results for an opcode or signature, depending on input
 *         parameters - iterate over the list to retrieve? tree-formed
 *         structure? or Google Collections (MultiTrees)?
 */
public class SerializableSettingBenchmarkingResults extends
		AbstractSettingBenchmarkingResults {

	/**
	 * TODO
	 */
	static final TreeMap<Integer, String> opcodeMap;

	/**
	 * Currently, this is the simplified ASM view ("proper" Java defines 026 as ILOAD_0, etc.)
	 * TODO rework to "standard" Java.
	 */
	public static final int[] opcodesInt = new int[] { 
		0,// "NOP"
		1,// "ACONST_NULL"
		2,// "ICONST_M1"
		3,// "ICONST_0"
		4,// "ICONST_1"
		5,// "ICONST_2"
		6,// "ICONST_3"
		7,// "ICONST_4"
		8,// "ICONST_5"
		9,// "LCONST_0"
		10,// "LCONST_1"
		11,// "FCONST_0"
		12,// "FCONST_1"
		13,// "FCONST_2"
		14,// "DCONST_0"
		15,// "DCONST_1"
		16,// "BIPUSH"
		17,// "SIPUSH"
		18,// "LDC"
		// 19,//"null"
		// 20,//"null"
		21,// "ILOAD"
		22,// "LLOAD"
		23,// "FLOAD"
		24,// "DLOAD"
		25,// "ALOAD"
		// 26,//"null"
		// 27,//"null"
		// 28,//"null"
		// 29,//"null"
		// 30,//"null"
		// 31,//"null"
		32,// "ACC_SYNCHRONIZED"
		// 33,//"null"
		// 34,//"null"
		// 35,//"null"
		// 36,//"null"
		// 37,//"null"
		// 38,//"null"
		// 39,//"null"
		// 40,//"null"
		// 41,//"null"
		// 42,//"null"
		// 43,//"null"
		// 44,//"null"
		// 45,//"null"
		46,// "IALOAD"
		47,// "LALOAD"
		48,// "FALOAD"
		49,// "DALOAD"
		50,// "AALOAD"
		51,// "BALOAD"
		52,// "CALOAD"
		53,// "SALOAD"
		54,// "ISTORE"
		55,// "LSTORE"
		56,// "FSTORE"
		57,// "DSTORE"
		58,// "ASTORE"
		// 59,//"null"
		// 60,//"null"
		// 61,//"null"
		// 62,//"null"
		// 63,//"null"
		64,// "ACC_BRIDGE"
		// 65,//"null"
		// 66,//"null"
		// 67,//"null"
		// 68,//"null"
		// 69,//"null"
		// 70,//"null"
		// 71,//"null"
		// 72,//"null"
		// 73,//"null"
		// 74,//"null"
		// 75,//"null"
		// 76,//"null"
		// 77,//"null"
		// 78,//"null"
		79,// "IASTORE"
		80,// "LASTORE"
		81,// "FASTORE"
		82,// "DASTORE"
		83,// "AASTORE"
		84,// "BASTORE"
		85,// "CASTORE"
		86,// "SASTORE"
		87,// "POP"
		88,// "POP2"
		89,// "DUP"
		90,// "DUP_X1"
		91,// "DUP_X2"
		92,// "DUP2"
		93,// "DUP2_X1"
		94,// "DUP2_X2"
		95,// "SWAP"
		96,// "IADD"
		97,// "LADD"
		98,// "FADD"
		99,// "DADD"
		100,// "ISUB"
		101,// "LSUB"
		102,// "FSUB"
		103,// "DSUB"
		104,// "IMUL"
		105,// "LMUL"
		106,// "FMUL"
		107,// "DMUL"
		108,// "IDIV"
		109,// "LDIV"
		110,// "FDIV"
		111,// "DDIV"
		112,// "IREM"
		113,// "LREM"
		114,// "FREM"
		115,// "DREM"
		116,// "INEG"
		117,// "LNEG"
		118,// "FNEG"
		119,// "DNEG"
		120,// "ISHL"
		121,// "LSHL"
		122,// "ISHR"
		123,// "LSHR"
		124,// "IUSHR"
		125,// "LUSHR"
		126,// "IAND"
		127,// "LAND"
		128,// "IOR"
		129,// "LOR"
		130,// "IXOR"
		131,// "LXOR"
		132,// "IINC"
		133,// "I2L"
		134,// "I2F"
		135,// "I2D"
		136,// "L2I"
		137,// "L2F"
		138,// "L2D"
		139,// "F2I"
		140,// "F2L"
		141,// "F2D"
		142,// "D2I"
		143,// "D2L"
		144,// "D2F"
		145,// "I2B"
		146,// "I2C"
		147,// "I2S"
		148,// "LCMP"
		149,// "FCMPL"
		150,// "FCMPG"
		151,// "DCMPL"
		152,// "DCMPG"
		153,// "IFEQ"
		154,// "IFNE"
		155,// "IFLT"
		156,// "IFGE"
		157,// "IFGT"
		158,// "IFLE"
		159,// "IF_ICMPEQ"
		160,// "IF_ICMPNE"
		161,// "IF_ICMPLT"
		162,// "IF_ICMPGE"
		163,// "IF_ICMPGT"
		164,// "IF_ICMPLE"
		165,// "IF_ACMPEQ"
		166,// "IF_ACMPNE"
		167,// "GOTO"
		168,// "JSR"
		169,// "RET"
		170,// "TABLESWITCH"
		171,// "LOOKUPSWITCH"
		172,// "IRETURN"
		173,// "LRETURN"
		174,// "FRETURN"
		175,// "DRETURN"
		176,// "ARETURN"
		177,// "RETURN"
		178,// "GETSTATIC"
		179,// "PUTSTATIC"
		180,// "GETFIELD"
		181,// "PUTFIELD"
		182,// "INVOKEVIRTUAL"
		183,// "INVOKESPECIAL"
		184,// "INVOKESTATIC"
		185,// "INVOKEINTERFACE"
		// 186,//"null"
		187,// "NEW"
		188,// "NEWARRAY"
		189,// "ANEWARRAY"
		190,// "ARRAYLENGTH"
		191,// "ATHROW"
		192,// "CHECKCAST"
		193,// "INSTANCEOF"
		194,// "MONITORENTER"
		195,// "MONITOREXIT"
		// 196,//"null"
		197,// "MULTIANEWARRAY"
		198,// "IFNULL"
		199 // "IFNONNULL"
		// 200,//"null"
		// 201,//"null"
		// 202,//"null"
		// 203,//"null"
		// 204,//"null"
		// 205,//"null"
		// 206,//"null"
		// 207,//"null"
		// 208,//"null"
		// 209,//"null"
		// 210,//"null"
		// 211,//"null"
		// 212,//"null"
		// 213,//"null"
		// 214,//"null"
		// 215,//"null"
		// 216,//"null"
		// 217,//"null"
		// 218,//"null"
		// 219,//"null"
		// 220,//"null"
		// 221,//"null"
		// 222,//"null"
		// 223,//"null"
		// 224,//"null"
		// 225,//"null"
		// 226,//"null"
		// 227,//"null"
		// 228,//"null"
		// 229,//"null"
		// 230,//"null"
		// 231,//"null"
		// 232,//"null"
		// 233,//"null"
		// 234,//"null"
		// 235,//"null"
		// 236,//"null"
		// 237,//"null"
		// 238,//"null"
		// 239,//"null"
		// 240,//"null"
		// 241,//"null"
		// 242,//"null"
		// 243,//"null"
		// 244,//"null"
		// 245,//"null"
		// 246,//"null"
		// 247,//"null"
		// 248,//"null"
		// 249,//"null"
		// 250,//"null"
		// 251,//"null"
		// 252,//"null"
		// 253,//"null"
		// 254,//"null"
		// 255//"null"
	};

	/**
	 * TODO
	 */
	public static final int opcodesNumber = opcodesInt.length;
	
	/**
	 * Currently, this is the simplified ASM view ("proper" Java defines 026 as ILOAD_0, etc.)
	 * TODO rework to "standard" Java. Also, make sure that capitalisation doesn't matter.
	 */
	public static final String[] opcodesString = new String[] {
		/* 0 */"NOP"
		/* 1 */, "ACONST_NULL"
		/* 2 */, "ICONST_M1"
		/* 3 */, "ICONST_0"
		/* 4 */, "ICONST_1"
		/* 5 */, "ICONST_2"
		/* 6 */, "ICONST_3"
		/* 7 */, "ICONST_4"
		/* 8 */, "ICONST_5"
		/* 9 */, "LCONST_0"
		/* 10 */, "LCONST_1"
		/* 11 */, "FCONST_0"
		/* 12 */, "FCONST_1"
		/* 13 */, "FCONST_2"
		/* 14 */, "DCONST_0"
		/* 15 */, "DCONST_1"
		/* 16 */, "BIPUSH"
		/* 17 */, "SIPUSH"
		/* 18 */, "LDC"
		// /*19*/,"null"
		// /*20*/,"null"
		/* 21 */, "ILOAD"
		/* 22 */, "LLOAD"
		/* 23 */, "FLOAD"
		/* 24 */, "DLOAD"
		/* 25 */, "ALOAD"
		// /*26*/,"null"
		// /*27*/,"null"
		// /*28*/,"null"
		// /*29*/,"null"
		// /*30*/,"null"
		// /*31*/,"null"
		/* 32 */, "ACC_SYNCHRONIZED"
		// /*33*/,"null"
		// /*34*/,"null"
		// /*35*/,"null"
		// /*36*/,"null"
		// /*37*/,"null"
		// /*38*/,"null"
		// /*39*/,"null"
		// /*40*/,"null"
		// /*41*/,"null"
		// /*42*/,"null"
		// /*43*/,"null"
		// /*44*/,"null"
		// /*45*/,"null"
		/* 46 */, "IALOAD"
		/* 47 */, "LALOAD"
		/* 48 */, "FALOAD"
		/* 49 */, "DALOAD"
		/* 50 */, "AALOAD"
		/* 51 */, "BALOAD"
		/* 52 */, "CALOAD"
		/* 53 */, "SALOAD"
		/* 54 */, "ISTORE"
		/* 55 */, "LSTORE"
		/* 56 */, "FSTORE"
		/* 57 */, "DSTORE"
		/* 58 */, "ASTORE"
		// /*59*/,"null"
		// /*60*/,"null"
		// /*61*/,"null"
		// /*62*/,"null"
		// /*63*/,"null"
		/* 64 */, "ACC_BRIDGE"
		// /*65*/,"null"
		// /*66*/,"null"
		// /*67*/,"null"
		// /*68*/,"null"
		// /*69*/,"null"
		// /*70*/,"null"
		// /*71*/,"null"
		// /*72*/,"null"
		// /*73*/,"null"
		// /*74*/,"null"
		// /*75*/,"null"
		// /*76*/,"null"
		// /*77*/,"null"
		// /*78*/,"null"
		/* 79 */, "IASTORE"
		/* 80 */, "LASTORE"
		/* 81 */, "FASTORE"
		/* 82 */, "DASTORE"
		/* 83 */, "AASTORE"
		/* 84 */, "BASTORE"
		/* 85 */, "CASTORE"
		/* 86 */, "SASTORE"
		/* 87 */, "POP"
		/* 88 */, "POP2"
		/* 89 */, "DUP"
		/* 90 */, "DUP_X1"
		/* 91 */, "DUP_X2"
		/* 92 */, "DUP2"
		/* 93 */, "DUP2_X1"
		/* 94 */, "DUP2_X2"
		/* 95 */, "SWAP"
		/* 96 */, "IADD"
		/* 97 */, "LADD"
		/* 98 */, "FADD"
		/* 99 */, "DADD"
		/* 100 */, "ISUB"
		/* 101 */, "LSUB"
		/* 102 */, "FSUB"
		/* 103 */, "DSUB"
		/* 104 */, "IMUL"
		/* 105 */, "LMUL"
		/* 106 */, "FMUL"
		/* 107 */, "DMUL"
		/* 108 */, "IDIV"
		/* 109 */, "LDIV"
		/* 110 */, "FDIV"
		/* 111 */, "DDIV"
		/* 112 */, "IREM"
		/* 113 */, "LREM"
		/* 114 */, "FREM"
		/* 115 */, "DREM"
		/* 116 */, "INEG"
		/* 117 */, "LNEG"
		/* 118 */, "FNEG"
		/* 119 */, "DNEG"
		/* 120 */, "ISHL"
		/* 121 */, "LSHL"
		/* 122 */, "ISHR"
		/* 123 */, "LSHR"
		/* 124 */, "IUSHR"
		/* 125 */, "LUSHR"
		/* 126 */, "IAND"
		/* 127 */, "LAND"
		/* 128 */, "IOR"
		/* 129 */, "LOR"
		/* 130 */, "IXOR"
		/* 131 */, "LXOR"
		/* 132 */, "IINC"
		/* 133 */, "I2L"
		/* 134 */, "I2F"
		/* 135 */, "I2D"
		/* 136 */, "L2I"
		/* 137 */, "L2F"
		/* 138 */, "L2D"
		/* 139 */, "F2I"
		/* 140 */, "F2L"
		/* 141 */, "F2D"
		/* 142 */, "D2I"
		/* 143 */, "D2L"
		/* 144 */, "D2F"
		/* 145 */, "I2B"
		/* 146 */, "I2C"
		/* 147 */, "I2S"
		/* 148 */, "LCMP"
		/* 149 */, "FCMPL"
		/* 150 */, "FCMPG"
		/* 151 */, "DCMPL"
		/* 152 */, "DCMPG"
		/* 153 */, "IFEQ"
		/* 154 */, "IFNE"
		/* 155 */, "IFLT"
		/* 156 */, "IFGE"
		/* 157 */, "IFGT"
		/* 158 */, "IFLE"
		/* 159 */, "IF_ICMPEQ"
		/* 160 */, "IF_ICMPNE"
		/* 161 */, "IF_ICMPLT"
		/* 162 */, "IF_ICMPGE"
		/* 163 */, "IF_ICMPGT"
		/* 164 */, "IF_ICMPLE"
		/* 165 */, "IF_ACMPEQ"
		/* 166 */, "IF_ACMPNE"
		/* 167 */, "GOTO"
		/* 168 */, "JSR"
		/* 169 */, "RET"
		/* 170 */, "TABLESWITCH"
		/* 171 */, "LOOKUPSWITCH"
		/* 172 */, "IRETURN"
		/* 173 */, "LRETURN"
		/* 174 */, "FRETURN"
		/* 175 */, "DRETURN"
		/* 176 */, "ARETURN"
		/* 177 */, "RETURN"
		/* 178 */, "GETSTATIC"
		/* 179 */, "PUTSTATIC"
		/* 180 */, "GETFIELD"
		/* 181 */, "PUTFIELD"
		/* 182 */, "INVOKEVIRTUAL"
		/* 183 */, "INVOKESPECIAL"
		/* 184 */, "INVOKESTATIC"
		/* 185 */, "INVOKEINTERFACE"
		// /*186*/,"null"
		/* 187 */, "NEW"
		/* 188 */, "NEWARRAY"
		/* 189 */, "ANEWARRAY"
		/* 190 */, "ARRAYLENGTH"
		/* 191 */, "ATHROW"
		/* 192 */, "CHECKCAST"
		/* 193 */, "INSTANCEOF"
		/* 194 */, "MONITORENTER"
		/* 195 */, "MONITOREXIT"
		// /*196*/,"null"
		/* 197 */, "MULTIANEWARRAY"
		/* 198 */, "IFNULL"
		/* 199 */, "IFNONNULL"
		// /*200*/,"null"
		// /*201*/,"null"
		// /*202*/,"null"
		// /*203*/,"null"
		// /*204*/,"null"
		// /*205*/,"null"
		// /*206*/,"null"
		// /*207*/,"null"
		// /*208*/,"null"
		// /*209*/,"null"
		// /*210*/,"null"
		// /*211*/,"null"
		// /*212*/,"null"
		// /*213*/,"null"
		// /*214*/,"null"
		// /*215*/,"null"
		// /*216*/,"null"
		// /*217*/,"null"
		// /*218*/,"null"
		// /*219*/,"null"
		// /*220*/,"null"
		// /*221*/,"null"
		// /*222*/,"null"
		// /*223*/,"null"
		// /*224*/,"null"
		// /*225*/,"null"
		// /*226*/,"null"
		// /*227*/,"null"
		// /*228*/,"null"
		// /*229*/,"null"
		// /*230*/,"null"
		// /*231*/,"null"
		// /*232*/,"null"
		// /*233*/,"null"
		// /*234*/,"null"
		// /*235*/,"null"
		// /*236*/,"null"
		// /*237*/,"null"
		// /*238*/,"null"
		// /*239*/,"null"
		// /*240*/,"null"
		// /*241*/,"null"
		// /*242*/,"null"
		// /*243*/,"null"
		// /*244*/,"null"
		// /*245*/,"null"
		// /*246*/,"null"
		// /*247*/,"null"
		// /*248*/,"null"
		// /*249*/,"null"
		// /*250*/,"null"
		// /*251*/,"null"
		// /*252*/,"null"
		// /*253*/,"null"
		// /*254*/,"null"
		// /*255*/,"null"
	};

	/**
	 * As usual
	 */
	private static final long serialVersionUID = 1L;

	static {
		opcodeMap = new TreeMap<Integer, String>();
		for (int i = 0; i < opcodesInt.length; i++) {
			opcodeMap.put(opcodesInt[i], opcodesString[i]);
		}
	}

	/**
	 * The actual benchmarking results
	 */
	TreeMap<String, AbstractBenchmarkingResult> results;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.BySuite.benchmarking.AbstractSettingBenchmarkingResults#getBenchmarkingResult_forOpcode(java.lang.String)
	 */
	@Override
	public AbstractBenchmarkingResult getBenchmarkingResult_forMnemonicOrSignature(
			String methodSignature) throws NoSuchMethodSignatureException {
		AbstractBenchmarkingResult abr = results.get(methodSignature);
		if (abr == null) {
			throw new NoSuchMethodSignatureException("TODO"); // TODO stimmt
																// nicht...
		} else {
			return abr;
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.BySuite.benchmarking.AbstractSettingBenchmarkingResults#getBenchmarkingResult_forOpcode(java.lang.String, java.lang.Object[], java.lang.String[])
	 */
	@Override
	public AbstractBenchmarkingResult getBenchmarkingResult_forMnemonicOrSignature(
			String methodSignature, Object[] parameterValues,
			String[] parameterTypes) throws NoSuchMethodSignatureException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.BySuite.benchmarking.AbstractSettingBenchmarkingResults#getBenchmarkingResult_forOpcode(int)
	 */
	@Override
	public AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(int opcode)
			throws NoSuchOpcodeException {
		if (opcodeMap.keySet().contains(opcode)) {
			AbstractBenchmarkingResult abr = results.get(
					this.getOpcodeStringByIntOpcode(opcode));
			if (abr == null) {
				throw new NoSuchOpcodeException("TODO"); // TODO
			} else {
				return abr;
			}
		} else {
			throw new NoSuchOpcodeException("TODO"); // TODO
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.BySuite.benchmarking.AbstractSettingBenchmarkingResults#getBenchmarkingResult_forOpcode(int, java.lang.Object[], java.lang.String[])
	 */
	@Override
	public AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			int opcode, 
			Object[] parameterValues, 
			String[] parameterTypes)
			throws NoSuchOpcodeException {
		try {
			throw new NoSuchScenarioException("TODO");
		} catch (NoSuchScenarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //
		return null;
	}

//	/* (non-Javadoc)
//	 * @see de.uka.ipd.sdq.BySuite.benchmarking.AbstractSettingBenchmarkingResults#getBenchmarkingResult_forScenario(java.lang.String)
//	 */
//	@Override
//	public AbstractBenchmarkingResult getBenchmarkingResult_forScenario(
//			String UID) throws NoSuchScenarioException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * TODO
	 * @param opcode
	 * @return
	 * @throws NoSuchOpcodeException
	 */
	public String getOpcodeStringByIntOpcode(int opcode)
			throws NoSuchOpcodeException {
		if (opcodeMap.keySet().contains(opcode)) {
			return opcodeMap.get(opcode);
		} else {
			throw new NoSuchOpcodeException("TODO"); // TODO
		}
	}

}
