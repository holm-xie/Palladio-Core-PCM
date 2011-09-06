package de.uka.ipd.sdq.stoex.analyser.tests;

import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.analyser.operations.TermProductOperation;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsParser;

public class ExpressionSolveVisitorTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	private ExpressionSolveVisitor getInstanceForExpression(Expression expr){
		ExpressionInferTypeVisitor inferTypeVisitor = new ExpressionInferTypeVisitor();
		inferTypeVisitor.doSwitch(expr);
		
		HashMap<Expression, TypeEnum> typeAnnotation = inferTypeVisitor
		.getTypeAnnotation();

		return new ExpressionSolveVisitor(typeAnnotation);
	}
	
	public void testExpressionHelper(String exprString, String expectedResultString) throws RecognitionException{
		StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
				new ANTLRStringStream(exprString));
		StochasticExpressionsParser parser = new StochasticExpressionsParser(
				new CommonTokenStream(lexer));

		Expression expr = parser.expression();
		
		ExpressionSolveVisitor visitor = getInstanceForExpression(expr);
		
		ProbabilityFunctionLiteral literal = (ProbabilityFunctionLiteral)visitor.doSwitch(expr);
		
		ProbabilityMassFunction pmf = (ProbabilityMassFunction)literal.getFunction_ProbabilityFunctionLiteral();
		
		IProbabilityMassFunction ipmf = IProbabilityFunctionFactory.eINSTANCE.transformToPMF(pmf);
		
		String computedResult = ipmf.getSamples().toString();
		System.out.println("Result: "+computedResult);
		
		double sum = MathTools.sumOfSamples(ipmf.getSamples());
		
		System.out.println(sum);
		
		assertFalse(sum > 1.0 + MathTools.EPSILON_ERROR);
		assertFalse(sum < 1.0 - MathTools.EPSILON_ERROR);
		
		
		assertEquals(expectedResultString, computedResult);
		
	}
	
	public void testTrunc1() throws RecognitionException{
		testExpressionHelper("Trunc(DoublePDF[ (0.2; 0.30000000) (2; 0.20000000) (3; 0.50000000) ])",
				"[(0, 0.3333), (1, 0.1111), (2, 0.3056), (3, 0.25)]");
	}
	
	public void testTrunc2() throws RecognitionException{
		testExpressionHelper("Trunc(DoublePDF[ (1.2; 0.30000000) (2; 0.20000000) (3; 0.50000000) ])",
				"[(0, 0.125), (1, 0.25), (2, 0.375), (3, 0.25)]");
	}
	
	public void testTruncLong() throws RecognitionException{
		testExpressionHelper("Trunc(DoublePDF[ (500000.0; 0.00000000) (1000000.0; 0.05100000) (2000000.0; 0.13400000) (3000000.0; 0.19300000) (4000000.0; 0.21200000) (5000000.0; 0.22400000) (6000000.0; 0.18600000) ])",
				"[(0, 0.0), (6001, 0.0), (12002, 0.0), (18003, 0.0), (24004, 0.0), (30005, 0.0), (36006, 0.0), (42007, 0.0), (48008, 0.0), (54009, 0.0), (60010, 0.0), (66011, 0.0), (72012, 0.0), (78013, 0.0), (84014, 0.0), (90015, 0.0), (96016, 0.0), (102017, 0.0), (108018, 0.0), (114019, 0.0), (120020, 0.0), (126021, 0.0), (132022, 0.0), (138023, 0.0), (144024, 0.0), (150025, 0.0), (156026, 0.0), (162027, 0.0), (168028, 0.0), (174029, 0.0), (180030, 0.0), (186031, 0.0), (192032, 0.0), (198033, 0.0), (204034, 0.0), (210035, 0.0), (216036, 0.0), (222037, 0.0), (228038, 0.0), (234039, 0.0), (240040, 0.0), (246041, 0.0), (252042, 0.0), (258043, 0.0), (264044, 0.0), (270045, 0.0), (276046, 0.0), (282047, 0.0), (288048, 0.0), (294049, 0.0), (300050, 0.0), (306051, 0.0), (312052, 0.0), (318053, 0.0), (324054, 0.0), (330055, 0.0), (336056, 0.0), (342057, 0.0), (348058, 0.0), (354059, 0.0), (360060, 0.0), (366061, 0.0), (372062, 0.0), (378063, 0.0), (384064, 0.0), (390065, 0.0), (396066, 0.0), (402067, 0.0), (408068, 0.0), (414069, 0.0), (420070, 0.0), (426071, 0.0), (432072, 0.0), (438073, 0.0), (444074, 0.0), (450075, 0.0), (456076, 0.0), (462077, 0.0), (468078, 0.0), (474079, 0.0), (480080, 0.0), (486081, 0.0), (492082, 0.0), (498083, 1.0E-4), (504084, 6.0E-4), (510085, 6.0E-4), (516086, 6.0E-4), (522087, 6.0E-4), (528088, 6.0E-4), (534089, 6.0E-4), (540090, 6.0E-4), (546091, 6.0E-4), (552092, 6.0E-4), (558093, 6.0E-4), (564094, 6.0E-4), (570095, 6.0E-4), (576096, 6.0E-4), (582097, 6.0E-4), (588098, 6.0E-4), (594099, 6.0E-4), (600100, 6.0E-4), (606101, 6.0E-4), (612102, 6.0E-4), (618103, 6.0E-4), (624104, 6.0E-4), (630105, 6.0E-4), (636106, 6.0E-4), (642107, 6.0E-4), (648108, 6.0E-4), (654109, 6.0E-4), (660110, 6.0E-4), (666111, 6.0E-4), (672112, 6.0E-4), (678113, 6.0E-4), (684114, 6.0E-4), (690115, 6.0E-4), (696116, 6.0E-4), (702117, 6.0E-4), (708118, 6.0E-4), (714119, 6.0E-4), (720120, 6.0E-4), (726121, 6.0E-4), (732122, 6.0E-4), (738123, 6.0E-4), (744124, 6.0E-4), (750125, 6.0E-4), (756126, 6.0E-4), (762127, 6.0E-4), (768128, 6.0E-4), (774129, 6.0E-4), (780130, 6.0E-4), (786131, 6.0E-4), (792132, 6.0E-4), (798133, 6.0E-4), (804134, 6.0E-4), (810135, 6.0E-4), (816136, 6.0E-4), (822137, 6.0E-4), (828138, 6.0E-4), (834139, 6.0E-4), (840140, 6.0E-4), (846141, 6.0E-4), (852142, 6.0E-4), (858143, 6.0E-4), (864144, 6.0E-4), (870145, 6.0E-4), (876146, 6.0E-4), (882147, 6.0E-4), (888148, 6.0E-4), (894149, 6.0E-4), (900150, 6.0E-4), (906151, 6.0E-4), (912152, 6.0E-4), (918153, 6.0E-4), (924154, 6.0E-4), (930155, 6.0E-4), (936156, 6.0E-4), (942157, 6.0E-4), (948158, 6.0E-4), (954159, 6.0E-4), (960160, 6.0E-4), (966161, 6.0E-4), (972162, 6.0E-4), (978163, 6.0E-4), (984164, 6.0E-4), (990165, 6.0E-4), (996166, 6.0E-4), (1002167, 8.0E-4), (1008168, 8.0E-4), (1014169, 8.0E-4), (1020170, 8.0E-4), (1026171, 8.0E-4), (1032172, 8.0E-4), (1038173, 8.0E-4), (1044174, 8.0E-4), (1050175, 8.0E-4), (1056176, 8.0E-4), (1062177, 8.0E-4), (1068178, 8.0E-4), (1074179, 8.0E-4), (1080180, 8.0E-4), (1086181, 8.0E-4), (1092182, 8.0E-4), (1098183, 8.0E-4), (1104184, 8.0E-4), (1110185, 8.0E-4), (1116186, 8.0E-4), (1122187, 8.0E-4), (1128188, 8.0E-4), (1134189, 8.0E-4), (1140190, 8.0E-4), (1146191, 8.0E-4), (1152192, 8.0E-4), (1158193, 8.0E-4), (1164194, 8.0E-4), (1170195, 8.0E-4), (1176196, 8.0E-4), (1182197, 8.0E-4), (1188198, 8.0E-4), (1194199, 8.0E-4), (1200200, 8.0E-4), (1206201, 8.0E-4), (1212202, 8.0E-4), (1218203, 8.0E-4), (1224204, 8.0E-4), (1230205, 8.0E-4), (1236206, 8.0E-4), (1242207, 8.0E-4), (1248208, 8.0E-4), (1254209, 8.0E-4), (1260210, 8.0E-4), (1266211, 8.0E-4), (1272212, 8.0E-4), (1278213, 8.0E-4), (1284214, 8.0E-4), (1290215, 8.0E-4), (1296216, 8.0E-4), (1302217, 8.0E-4), (1308218, 8.0E-4), (1314219, 8.0E-4), (1320220, 8.0E-4), (1326221, 8.0E-4), (1332222, 8.0E-4), (1338223, 8.0E-4), (1344224, 8.0E-4), (1350225, 8.0E-4), (1356226, 8.0E-4), (1362227, 8.0E-4), (1368228, 8.0E-4), (1374229, 8.0E-4), (1380230, 8.0E-4), (1386231, 8.0E-4), (1392232, 8.0E-4), (1398233, 8.0E-4), (1404234, 8.0E-4), (1410235, 8.0E-4), (1416236, 8.0E-4), (1422237, 8.0E-4), (1428238, 8.0E-4), (1434239, 8.0E-4), (1440240, 8.0E-4), (1446241, 8.0E-4), (1452242, 8.0E-4), (1458243, 8.0E-4), (1464244, 8.0E-4), (1470245, 8.0E-4), (1476246, 8.0E-4), (1482247, 8.0E-4), (1488248, 8.0E-4), (1494249, 8.0E-4), (1500250, 8.0E-4), (1506251, 8.0E-4), (1512252, 8.0E-4), (1518253, 8.0E-4), (1524254, 8.0E-4), (1530255, 8.0E-4), (1536256, 8.0E-4), (1542257, 8.0E-4), (1548258, 8.0E-4), (1554259, 8.0E-4), (1560260, 8.0E-4), (1566261, 8.0E-4), (1572262, 8.0E-4), (1578263, 8.0E-4), (1584264, 8.0E-4), (1590265, 8.0E-4), (1596266, 8.0E-4), (1602267, 8.0E-4), (1608268, 8.0E-4), (1614269, 8.0E-4), (1620270, 8.0E-4), (1626271, 8.0E-4), (1632272, 8.0E-4), (1638273, 8.0E-4), (1644274, 8.0E-4), (1650275, 8.0E-4), (1656276, 8.0E-4), (1662277, 8.0E-4), (1668278, 8.0E-4), (1674279, 8.0E-4), (1680280, 8.0E-4), (1686281, 8.0E-4), (1692282, 8.0E-4), (1698283, 8.0E-4), (1704284, 8.0E-4), (1710285, 8.0E-4), (1716286, 8.0E-4), (1722287, 8.0E-4), (1728288, 8.0E-4), (1734289, 8.0E-4), (1740290, 8.0E-4), (1746291, 8.0E-4), (1752292, 8.0E-4), (1758293, 8.0E-4), (1764294, 8.0E-4), (1770295, 8.0E-4), (1776296, 8.0E-4), (1782297, 8.0E-4), (1788298, 8.0E-4), (1794299, 8.0E-4), (1800300, 8.0E-4), (1806301, 8.0E-4), (1812302, 8.0E-4), (1818303, 8.0E-4), (1824304, 8.0E-4), (1830305, 8.0E-4), (1836306, 8.0E-4), (1842307, 8.0E-4), (1848308, 8.0E-4), (1854309, 8.0E-4), (1860310, 8.0E-4), (1866311, 8.0E-4), (1872312, 8.0E-4), (1878313, 8.0E-4), (1884314, 8.0E-4), (1890315, 8.0E-4), (1896316, 8.0E-4), (1902317, 8.0E-4), (1908318, 8.0E-4), (1914319, 8.0E-4), (1920320, 8.0E-4), (1926321, 8.0E-4), (1932322, 8.0E-4), (1938323, 8.0E-4), (1944324, 8.0E-4), (1950325, 8.0E-4), (1956326, 8.0E-4), (1962327, 8.0E-4), (1968328, 8.0E-4), (1974329, 8.0E-4), (1980330, 8.0E-4), (1986331, 8.0E-4), (1992332, 8.0E-4), (1998333, 9.0E-4), (2004334, 0.0012), (2010335, 0.0012), (2016336, 0.0012), (2022337, 0.0012), (2028338, 0.0012), (2034339, 0.0012), (2040340, 0.0012), (2046341, 0.0012), (2052342, 0.0012), (2058343, 0.0012), (2064344, 0.0012), (2070345, 0.0012), (2076346, 0.0012), (2082347, 0.0012), (2088348, 0.0012), (2094349, 0.0012), (2100350, 0.0012), (2106351, 0.0012), (2112352, 0.0012), (2118353, 0.0012), (2124354, 0.0012), (2130355, 0.0012), (2136356, 0.0012), (2142357, 0.0012), (2148358, 0.0012), (2154359, 0.0012), (2160360, 0.0012), (2166361, 0.0012), (2172362, 0.0012), (2178363, 0.0012), (2184364, 0.0012), (2190365, 0.0012), (2196366, 0.0012), (2202367, 0.0012), (2208368, 0.0012), (2214369, 0.0012), (2220370, 0.0012), (2226371, 0.0012), (2232372, 0.0012), (2238373, 0.0012), (2244374, 0.0012), (2250375, 0.0012), (2256376, 0.0012), (2262377, 0.0012), (2268378, 0.0012), (2274379, 0.0012), (2280380, 0.0012), (2286381, 0.0012), (2292382, 0.0012), (2298383, 0.0012), (2304384, 0.0012), (2310385, 0.0012), (2316386, 0.0012), (2322387, 0.0012), (2328388, 0.0012), (2334389, 0.0012), (2340390, 0.0012), (2346391, 0.0012), (2352392, 0.0012), (2358393, 0.0012), (2364394, 0.0012), (2370395, 0.0012), (2376396, 0.0012), (2382397, 0.0012), (2388398, 0.0012), (2394399, 0.0012), (2400400, 0.0012), (2406401, 0.0012), (2412402, 0.0012), (2418403, 0.0012), (2424404, 0.0012), (2430405, 0.0012), (2436406, 0.0012), (2442407, 0.0012), (2448408, 0.0012), (2454409, 0.0012), (2460410, 0.0012), (2466411, 0.0012), (2472412, 0.0012), (2478413, 0.0012), (2484414, 0.0012), (2490415, 0.0012), (2496416, 0.0012), (2502417, 0.0012), (2508418, 0.0012), (2514419, 0.0012), (2520420, 0.0012), (2526421, 0.0012), (2532422, 0.0012), (2538423, 0.0012), (2544424, 0.0012), (2550425, 0.0012), (2556426, 0.0012), (2562427, 0.0012), (2568428, 0.0012), (2574429, 0.0012), (2580430, 0.0012), (2586431, 0.0012), (2592432, 0.0012), (2598433, 0.0012), (2604434, 0.0012), (2610435, 0.0012), (2616436, 0.0012), (2622437, 0.0012), (2628438, 0.0012), (2634439, 0.0012), (2640440, 0.0012), (2646441, 0.0012), (2652442, 0.0012), (2658443, 0.0012), (2664444, 0.0012), (2670445, 0.0012), (2676446, 0.0012), (2682447, 0.0012), (2688448, 0.0012), (2694449, 0.0012), (2700450, 0.0012), (2706451, 0.0012), (2712452, 0.0012), (2718453, 0.0012), (2724454, 0.0012), (2730455, 0.0012), (2736456, 0.0012), (2742457, 0.0012), (2748458, 0.0012), (2754459, 0.0012), (2760460, 0.0012), (2766461, 0.0012), (2772462, 0.0012), (2778463, 0.0012), (2784464, 0.0012), (2790465, 0.0012), (2796466, 0.0012), (2802467, 0.0012), (2808468, 0.0012), (2814469, 0.0012), (2820470, 0.0012), (2826471, 0.0012), (2832472, 0.0012), (2838473, 0.0012), (2844474, 0.0012), (2850475, 0.0012), (2856476, 0.0012), (2862477, 0.0012), (2868478, 0.0012), (2874479, 0.0012), (2880480, 0.0012), (2886481, 0.0012), (2892482, 0.0012), (2898483, 0.0012), (2904484, 0.0012), (2910485, 0.0012), (2916486, 0.0012), (2922487, 0.0012), (2928488, 0.0012), (2934489, 0.0012), (2940490, 0.0012), (2946491, 0.0012), (2952492, 0.0012), (2958493, 0.0012), (2964494, 0.0012), (2970495, 0.0012), (2976496, 0.0012), (2982497, 0.0012), (2988498, 0.0012), (2994499, 0.0012), (3000500, 0.0012), (3006501, 0.0013), (3012502, 0.0013), (3018503, 0.0013), (3024504, 0.0013), (3030505, 0.0013), (3036506, 0.0013), (3042507, 0.0013), (3048508, 0.0013), (3054509, 0.0013), (3060510, 0.0013), (3066511, 0.0013), (3072512, 0.0013), (3078513, 0.0013), (3084514, 0.0013), (3090515, 0.0013), (3096516, 0.0013), (3102517, 0.0013), (3108518, 0.0013), (3114519, 0.0013), (3120520, 0.0013), (3126521, 0.0013), (3132522, 0.0013), (3138523, 0.0013), (3144524, 0.0013), (3150525, 0.0013), (3156526, 0.0013), (3162527, 0.0013), (3168528, 0.0013), (3174529, 0.0013), (3180530, 0.0013), (3186531, 0.0013), (3192532, 0.0013), (3198533, 0.0013), (3204534, 0.0013), (3210535, 0.0013), (3216536, 0.0013), (3222537, 0.0013), (3228538, 0.0013), (3234539, 0.0013), (3240540, 0.0013), (3246541, 0.0013), (3252542, 0.0013), (3258543, 0.0013), (3264544, 0.0013), (3270545, 0.0013), (3276546, 0.0013), (3282547, 0.0013), (3288548, 0.0013), (3294549, 0.0013), (3300550, 0.0013), (3306551, 0.0013), (3312552, 0.0013), (3318553, 0.0013), (3324554, 0.0013), (3330555, 0.0013), (3336556, 0.0013), (3342557, 0.0013), (3348558, 0.0013), (3354559, 0.0013), (3360560, 0.0013), (3366561, 0.0013), (3372562, 0.0013), (3378563, 0.0013), (3384564, 0.0013), (3390565, 0.0013), (3396566, 0.0013), (3402567, 0.0013), (3408568, 0.0013), (3414569, 0.0013), (3420570, 0.0013), (3426571, 0.0013), (3432572, 0.0013), (3438573, 0.0013), (3444574, 0.0013), (3450575, 0.0013), (3456576, 0.0013), (3462577, 0.0013), (3468578, 0.0013), (3474579, 0.0013), (3480580, 0.0013), (3486581, 0.0013), (3492582, 0.0013), (3498583, 0.0013), (3504584, 0.0013), (3510585, 0.0013), (3516586, 0.0013), (3522587, 0.0013), (3528588, 0.0013), (3534589, 0.0013), (3540590, 0.0013), (3546591, 0.0013), (3552592, 0.0013), (3558593, 0.0013), (3564594, 0.0013), (3570595, 0.0013), (3576596, 0.0013), (3582597, 0.0013), (3588598, 0.0013), (3594599, 0.0013), (3600600, 0.0013), (3606601, 0.0013), (3612602, 0.0013), (3618603, 0.0013), (3624604, 0.0013), (3630605, 0.0013), (3636606, 0.0013), (3642607, 0.0013), (3648608, 0.0013), (3654609, 0.0013), (3660610, 0.0013), (3666611, 0.0013), (3672612, 0.0013), (3678613, 0.0013), (3684614, 0.0013), (3690615, 0.0013), (3696616, 0.0013), (3702617, 0.0013), (3708618, 0.0013), (3714619, 0.0013), (3720620, 0.0013), (3726621, 0.0013), (3732622, 0.0013), (3738623, 0.0013), (3744624, 0.0013), (3750625, 0.0013), (3756626, 0.0013), (3762627, 0.0013), (3768628, 0.0013), (3774629, 0.0013), (3780630, 0.0013), (3786631, 0.0013), (3792632, 0.0013), (3798633, 0.0013), (3804634, 0.0013), (3810635, 0.0013), (3816636, 0.0013), (3822637, 0.0013), (3828638, 0.0013), (3834639, 0.0013), (3840640, 0.0013), (3846641, 0.0013), (3852642, 0.0013), (3858643, 0.0013), (3864644, 0.0013), (3870645, 0.0013), (3876646, 0.0013), (3882647, 0.0013), (3888648, 0.0013), (3894649, 0.0013), (3900650, 0.0013), (3906651, 0.0013), (3912652, 0.0013), (3918653, 0.0013), (3924654, 0.0013), (3930655, 0.0013), (3936656, 0.0013), (3942657, 0.0013), (3948658, 0.0013), (3954659, 0.0013), (3960660, 0.0013), (3966661, 0.0013), (3972662, 0.0013), (3978663, 0.0013), (3984664, 0.0013), (3990665, 0.0013), (3996666, 0.0013), (4002667, 0.0013), (4008668, 0.0013), (4014669, 0.0013), (4020670, 0.0013), (4026671, 0.0013), (4032672, 0.0013), (4038673, 0.0013), (4044674, 0.0013), (4050675, 0.0013), (4056676, 0.0013), (4062677, 0.0013), (4068678, 0.0013), (4074679, 0.0013), (4080680, 0.0013), (4086681, 0.0013), (4092682, 0.0013), (4098683, 0.0013), (4104684, 0.0013), (4110685, 0.0013), (4116686, 0.0013), (4122687, 0.0013), (4128688, 0.0013), (4134689, 0.0013), (4140690, 0.0013), (4146691, 0.0013), (4152692, 0.0013), (4158693, 0.0013), (4164694, 0.0013), (4170695, 0.0013), (4176696, 0.0013), (4182697, 0.0013), (4188698, 0.0013), (4194699, 0.0013), (4200700, 0.0013), (4206701, 0.0013), (4212702, 0.0013), (4218703, 0.0013), (4224704, 0.0013), (4230705, 0.0013), (4236706, 0.0013), (4242707, 0.0013), (4248708, 0.0013), (4254709, 0.0013), (4260710, 0.0013), (4266711, 0.0013), (4272712, 0.0013), (4278713, 0.0013), (4284714, 0.0013), (4290715, 0.0013), (4296716, 0.0013), (4302717, 0.0013), (4308718, 0.0013), (4314719, 0.0013), (4320720, 0.0013), (4326721, 0.0013), (4332722, 0.0013), (4338723, 0.0013), (4344724, 0.0013), (4350725, 0.0013), (4356726, 0.0013), (4362727, 0.0013), (4368728, 0.0013), (4374729, 0.0013), (4380730, 0.0013), (4386731, 0.0013), (4392732, 0.0013), (4398733, 0.0013), (4404734, 0.0013), (4410735, 0.0013), (4416736, 0.0013), (4422737, 0.0013), (4428738, 0.0013), (4434739, 0.0013), (4440740, 0.0013), (4446741, 0.0013), (4452742, 0.0013), (4458743, 0.0013), (4464744, 0.0013), (4470745, 0.0013), (4476746, 0.0013), (4482747, 0.0013), (4488748, 0.0013), (4494749, 0.0013), (4500750, 0.0013), (4506751, 0.0013), (4512752, 0.0013), (4518753, 0.0013), (4524754, 0.0013), (4530755, 0.0013), (4536756, 0.0013), (4542757, 0.0013), (4548758, 0.0013), (4554759, 0.0013), (4560760, 0.0013), (4566761, 0.0013), (4572762, 0.0013), (4578763, 0.0013), (4584764, 0.0013), (4590765, 0.0013), (4596766, 0.0013), (4602767, 0.0013), (4608768, 0.0013), (4614769, 0.0013), (4620770, 0.0013), (4626771, 0.0013), (4632772, 0.0013), (4638773, 0.0013), (4644774, 0.0013), (4650775, 0.0013), (4656776, 0.0013), (4662777, 0.0013), (4668778, 0.0013), (4674779, 0.0013), (4680780, 0.0013), (4686781, 0.0013), (4692782, 0.0013), (4698783, 0.0013), (4704784, 0.0013), (4710785, 0.0013), (4716786, 0.0013), (4722787, 0.0013), (4728788, 0.0013), (4734789, 0.0013), (4740790, 0.0013), (4746791, 0.0013), (4752792, 0.0013), (4758793, 0.0013), (4764794, 0.0013), (4770795, 0.0013), (4776796, 0.0013), (4782797, 0.0013), (4788798, 0.0013), (4794799, 0.0013), (4800800, 0.0013), (4806801, 0.0013), (4812802, 0.0013), (4818803, 0.0013), (4824804, 0.0013), (4830805, 0.0013), (4836806, 0.0013), (4842807, 0.0013), (4848808, 0.0013), (4854809, 0.0013), (4860810, 0.0013), (4866811, 0.0013), (4872812, 0.0013), (4878813, 0.0013), (4884814, 0.0013), (4890815, 0.0013), (4896816, 0.0013), (4902817, 0.0013), (4908818, 0.0013), (4914819, 0.0013), (4920820, 0.0013), (4926821, 0.0013), (4932822, 0.0013), (4938823, 0.0013), (4944824, 0.0013), (4950825, 0.0013), (4956826, 0.0013), (4962827, 0.0013), (4968828, 0.0013), (4974829, 0.0013), (4980830, 0.0013), (4986831, 0.0013), (4992832, 0.0013), (4998833, 0.0013), (5004834, 0.0011), (5010835, 0.0011), (5016836, 0.0011), (5022837, 0.0011), (5028838, 0.0011), (5034839, 0.0011), (5040840, 0.0011), (5046841, 0.0011), (5052842, 0.0011), (5058843, 0.0011), (5064844, 0.0011), (5070845, 0.0011), (5076846, 0.0011), (5082847, 0.0011), (5088848, 0.0011), (5094849, 0.0011), (5100850, 0.0011), (5106851, 0.0011), (5112852, 0.0011), (5118853, 0.0011), (5124854, 0.0011), (5130855, 0.0011), (5136856, 0.0011), (5142857, 0.0011), (5148858, 0.0011), (5154859, 0.0011), (5160860, 0.0011), (5166861, 0.0011), (5172862, 0.0011), (5178863, 0.0011), (5184864, 0.0011), (5190865, 0.0011), (5196866, 0.0011), (5202867, 0.0011), (5208868, 0.0011), (5214869, 0.0011), (5220870, 0.0011), (5226871, 0.0011), (5232872, 0.0011), (5238873, 0.0011), (5244874, 0.0011), (5250875, 0.0011), (5256876, 0.0011), (5262877, 0.0011), (5268878, 0.0011), (5274879, 0.0011), (5280880, 0.0011), (5286881, 0.0011), (5292882, 0.0011), (5298883, 0.0011), (5304884, 0.0011), (5310885, 0.0011), (5316886, 0.0011), (5322887, 0.0011), (5328888, 0.0011), (5334889, 0.0011), (5340890, 0.0011), (5346891, 0.0011), (5352892, 0.0011), (5358893, 0.0011), (5364894, 0.0011), (5370895, 0.0011), (5376896, 0.0011), (5382897, 0.0011), (5388898, 0.0011), (5394899, 0.0011), (5400900, 0.0011), (5406901, 0.0011), (5412902, 0.0011), (5418903, 0.0011), (5424904, 0.0011), (5430905, 0.0011), (5436906, 0.0011), (5442907, 0.0011), (5448908, 0.0011), (5454909, 0.0011), (5460910, 0.0011), (5466911, 0.0011), (5472912, 0.0011), (5478913, 0.0011), (5484914, 0.0011), (5490915, 0.0011), (5496916, 0.0011), (5502917, 0.0011), (5508918, 0.0011), (5514919, 0.0011), (5520920, 0.0011), (5526921, 0.0011), (5532922, 0.0011), (5538923, 0.0011), (5544924, 0.0011), (5550925, 0.0011), (5556926, 0.0011), (5562927, 0.0011), (5568928, 0.0011), (5574929, 0.0011), (5580930, 0.0011), (5586931, 0.0011), (5592932, 0.0011), (5598933, 0.0011), (5604934, 0.0011), (5610935, 0.0011), (5616936, 0.0011), (5622937, 0.0011), (5628938, 0.0011), (5634939, 0.0011), (5640940, 0.0011), (5646941, 0.0011), (5652942, 0.0011), (5658943, 0.0011), (5664944, 0.0011), (5670945, 0.0011), (5676946, 0.0011), (5682947, 0.0011), (5688948, 0.0011), (5694949, 0.0011), (5700950, 0.0011), (5706951, 0.0011), (5712952, 0.0011), (5718953, 0.0011), (5724954, 0.0011), (5730955, 0.0011), (5736956, 0.0011), (5742957, 0.0011), (5748958, 0.0011), (5754959, 0.0011), (5760960, 0.0011), (5766961, 0.0011), (5772962, 0.0011), (5778963, 0.0011), (5784964, 0.0011), (5790965, 0.0011), (5796966, 0.0011), (5802967, 0.0011), (5808968, 0.0011), (5814969, 0.0011), (5820970, 0.0011), (5826971, 0.0011), (5832972, 0.0011), (5838973, 0.0011), (5844974, 0.0011), (5850975, 0.0011), (5856976, 0.0011), (5862977, 0.0011), (5868978, 0.0011), (5874979, 0.0011), (5880980, 0.0011), (5886981, 0.0011), (5892982, 0.0011), (5898983, 0.0011), (5904984, 0.0011), (5910985, 0.0011), (5916986, 0.0011), (5922987, 0.0011), (5928988, 0.0011), (5934989, 0.0011), (5940990, 0.0011), (5946991, 0.0011), (5952992, 0.0011), (5958993, 0.0011), (5964994, 0.0011), (5970995, 0.0011), (5976996, 0.0011), (5982997, 0.0011), (5988998, 0.0011), (5994999, 0.0011), (6001000, 4.0E-4)]");
	}
	
	public void testTruncSmall() throws RecognitionException{
		testExpressionHelper("Trunc(DoublePDF[ (0.2; 0.30000000) (0.3; 0.20000000) (0.4; 0.50000000) ])",
				"[(0, 1.0)]");
	}
	
	public void testMultPMF1() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.5)(2;0.5)]*IntPMF[(3;0.5)(4;0.5)]",
				"[(3, 0.25), (4, 0.25), (6, 0.25), (8, 0.25)]");
	}
	
	public void testMultPMF2() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.4)(2;0.6)]*IntPMF[(3;0.3)(4;0.7)]",
				"[(3, 0.12), (4, 0.28), (6, 0.18), (8, 0.42)]");
	}
	
	// mult with constant
	public void testMultPMF3() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.4)(2;0.6)]*3",
				"[(3, 0.4), (6, 0.6)]");
	}

//  Calculations with two PDF are not supported. 
//	What would actually be the expected results?
//  implement in de.uka.ipd.sdq.stoex.analyser.operations.TermProductOperation
//	public void testMultPDF1(){
//		testExpressionHelper("DoublePDF[(1;0.4)(2;0.6)]*DoublePDF[(3;0.3)(4;0.7)]",
//				"");
//	}
	
	public void testAddPMF1() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.4)(2;0.6)]+IntPMF[(3;0.3)(4;0.7)]",
				"[(4, 0.12), (5, 0.46), (6, 0.42)]");
	}
	
	public void testAddPMF2() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.4)(5;0.5)(6;0.1)]+IntPMF[(7;0.3)(8;0.5)(9;0.2)]",
				"[(8, 0.12), (9, 0.2), (10, 0.08), (12, 0.15), (13, 0.28), (14, 0.15), (15, 0.02)]");
	}
	
	public void testAddPMF3() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.4)(2;0.6)]+IntPMF[(3;0.3)(20;0.7)]",
				"[(4, 0.12), (5, 0.18), (21, 0.28), (22, 0.42)]");
	}
	
	// add with constant
	public void testAddPMF4() throws RecognitionException{
		testExpressionHelper("IntPMF[(1;0.4)(2;0.6)]+5",
				"[(6, 0.4), (7, 0.6)]");
	}
	
	public void testDivPMF1() throws RecognitionException{
		//These expected results have not been checked in detail, they may be wrong		
		testExpressionHelper("IntPMF[(10;0.4)(20;0.6)]/IntPMF[(2;0.3)(3;0.7)]",
				"[(3, 0.28), (5, 0.12), (6, 0.42), (10, 0.18)]");
	}
	
	public void testDivPMF2() throws RecognitionException{
		//These expected results have not been checked in detail, they may be wrong
		testExpressionHelper("DoublePMF[(10;0.4)(20;0.6)]/DoublePMF[(2;0.3)(3;0.7)]",
				"[(3.3333333333333335, 0.28), (5.0, 0.12), (6.666666666666667, 0.42), (10.0, 0.18)]");
	}
	
	// div with constant
	public void testDivPMF3() throws RecognitionException{
		testExpressionHelper("IntPMF[(10;0.4)(20;0.6)]/10",
				"[(1.0, 0.4), (2.0, 0.6)]");
	}
	
	public void testSubPMF1() throws RecognitionException{
		testExpressionHelper("IntPMF[(10;0.4)(20;0.6)]-IntPMF[(3;0.3)(7;0.7)]",
				"[(3, 0.28), (7, 0.12), (13, 0.42), (17, 0.18)]");
	}
	
	// sub with constant
	public void testSubPMF2() throws RecognitionException{
		testExpressionHelper("IntPMF[(10;0.4)(20;0.6)]-3",
				"[(7, 0.4), (17, 0.6)]");
	}

}
