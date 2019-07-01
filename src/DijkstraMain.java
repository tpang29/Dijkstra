//This class will contain the main function to run the algorithm.

public class DijkstraMain {

    public static void main(String[] args) {

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");

        Vertex vertexF = new Vertex("F");
        Vertex vertexG = new Vertex("G");
        Vertex vertexH = new Vertex("H");
        Vertex vertexI = new Vertex("I");
        Vertex vertexJ = new Vertex("J");
        Vertex vertexK = new Vertex("K");
        Vertex vertexL = new Vertex("L");
        Vertex vertexM = new Vertex("M");
        Vertex vertexN = new Vertex("N");
        Vertex vertexO = new Vertex("O");
        Vertex vertexP = new Vertex("P");
        Vertex vertexQ = new Vertex("Q");
        Vertex vertexR = new Vertex("R");
        Vertex vertexS = new Vertex("S");
        Vertex vertexT = new Vertex("T");


        vertexA.addNeighbour(new Edge(100,vertexA,vertexM));
        vertexA.addNeighbour(new Edge(75,vertexA,vertexB));
        vertexA.addNeighbour(new Edge(65,vertexA,vertexE));
        vertexA.addNeighbour(new Edge(118,vertexA,vertexC));

        vertexB.addNeighbour(new Edge(75,vertexB,vertexA));
        vertexB.addNeighbour(new Edge(120,vertexB,vertexF));
        vertexB.addNeighbour(new Edge(100,vertexB,vertexJ));

        vertexC.addNeighbour(new Edge(118,vertexC,vertexA));
        vertexC.addNeighbour(new Edge(90,vertexC,vertexE));
        vertexC.addNeighbour(new Edge(40,vertexC,vertexN));
        vertexC.addNeighbour(new Edge(85,vertexC,vertexD));

        vertexD.addNeighbour(new Edge(85,vertexD,vertexC));
        vertexD.addNeighbour(new Edge(70,vertexD,vertexG));
        vertexD.addNeighbour(new Edge(130,vertexD,vertexO));
        vertexD.addNeighbour(new Edge(60,vertexD,vertexP));

        vertexE.addNeighbour(new Edge(65,vertexE,vertexA));
        vertexE.addNeighbour(new Edge(90,vertexE,vertexC));
        vertexE.addNeighbour(new Edge(80,vertexE,vertexG));
        vertexE.addNeighbour(new Edge(99,vertexE,vertexF));

        vertexF.addNeighbour(new Edge(60,vertexF,vertexK));
        vertexF.addNeighbour(new Edge(30,vertexF,vertexJ));
        vertexF.addNeighbour(new Edge(211,vertexF,vertexI));
        vertexF.addNeighbour(new Edge(99,vertexF,vertexE));

        vertexG.addNeighbour(new Edge(70,vertexG,vertexD));
        vertexG.addNeighbour(new Edge(80,vertexG,vertexE));
        vertexG.addNeighbour(new Edge(97,vertexG,vertexH));
        vertexG.addNeighbour(new Edge(130,vertexG,vertexI));

        vertexH.addNeighbour(new Edge(100,vertexH,vertexD));
        vertexH.addNeighbour(new Edge(97,vertexH,vertexG));
        vertexH.addNeighbour(new Edge(40,vertexH,vertexR));
        vertexH.addNeighbour(new Edge(30,vertexH,vertexT));
        vertexH.addNeighbour(new Edge(101,vertexH,vertexI));

        vertexI.addNeighbour(new Edge(101,vertexI,vertexH));
        vertexI.addNeighbour(new Edge(130,vertexI,vertexG));
        vertexI.addNeighbour(new Edge(211,vertexI,vertexF));
        vertexI.addNeighbour(new Edge(80,vertexI,vertexT));
        vertexI.addNeighbour(new Edge(50,vertexI,vertexL));

        vertexJ.addNeighbour(new Edge(100,vertexJ,vertexB));
        vertexJ.addNeighbour(new Edge(30,vertexJ,vertexF));
        vertexJ.addNeighbour(new Edge(70,vertexJ,vertexK));

        vertexK.addNeighbour(new Edge(60,vertexK,vertexF));
        vertexK.addNeighbour(new Edge(70,vertexK,vertexJ));
        vertexK.addNeighbour(new Edge(40,vertexK,vertexL));

        vertexL.addNeighbour(new Edge(40,vertexL,vertexK));
        vertexL.addNeighbour(new Edge(50,vertexL,vertexI));

        vertexM.addNeighbour(new Edge(100,vertexM,vertexA));
        vertexM.addNeighbour(new Edge(90,vertexM,vertexO));
        vertexM.addNeighbour(new Edge(30,vertexM,vertexN));

        vertexO.addNeighbour(new Edge(90,vertexO,vertexM));
        vertexO.addNeighbour(new Edge(80,vertexO,vertexN));
        vertexO.addNeighbour(new Edge(130,vertexO,vertexD));
        vertexO.addNeighbour(new Edge(100,vertexO,vertexP));
        vertexO.addNeighbour(new Edge(80,vertexO,vertexQ));

        vertexP.addNeighbour(new Edge(80,vertexP,vertexR));
        vertexP.addNeighbour(new Edge(100,vertexP,vertexO));
        vertexP.addNeighbour(new Edge(20,vertexP,vertexQ));
        vertexP.addNeighbour(new Edge(60,vertexP,vertexD));

        vertexQ.addNeighbour(new Edge(80,vertexQ,vertexO));
        vertexQ.addNeighbour(new Edge(20,vertexQ,vertexP));
        vertexQ.addNeighbour(new Edge(70,vertexQ,vertexR));
        vertexQ.addNeighbour(new Edge(40,vertexQ,vertexS));

        vertexR.addNeighbour(new Edge(80,vertexR,vertexP));
        vertexR.addNeighbour(new Edge(70,vertexR,vertexQ));
        vertexR.addNeighbour(new Edge(50,vertexR,vertexS));
        vertexR.addNeighbour(new Edge(40,vertexR,vertexH));

        vertexS.addNeighbour(new Edge(50,vertexS,vertexR));
        vertexS.addNeighbour(new Edge(40,vertexS,vertexQ));
        vertexS.addNeighbour(new Edge(60,vertexS,vertexT));

        vertexT.addNeighbour(new Edge(60,vertexT,vertexS));
        vertexT.addNeighbour(new Edge(30,vertexT,vertexH));
        vertexT.addNeighbour(new Edge(80,vertexT,vertexI));


        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.computeShortestPaths(vertexA);

        System.out.println("======================================");
        System.out.println("Calculating minimum distance");
        System.out.println("======================================");

        System.out.println("Minimum distance from A to I: "+vertexI.getDistance());

        System.out.println("=====================	=================");
        System.out.println("Calculating Paths");
        System.out.println("======================================");

        System.out.println("Shortest Path from A to I: "+shortestPath.getShortestPathTo(vertexI));


    }
}