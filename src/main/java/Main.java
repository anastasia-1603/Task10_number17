import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        run(parseArgs(args));
    }

    public static InputArgs parseArgs(String[] args)
    {
        InputArgs inputArgs = new InputArgs();
        if (args.length > 0)
        {
            if (args[0].equals("help"))
            {
                inputArgs.help = true;
                return inputArgs;
            }
            else
            {
                inputArgs.inputFile = args[0];
                inputArgs.outputFile = args[1];
            }
        }
        else
        {
            inputArgs.help = true;
            inputArgs.error = true;
        }
        return inputArgs;
    }

    public static void run(InputArgs inputArgs) throws FileNotFoundException
    {
        if (inputArgs.help)
        {
            if (inputArgs.error)
            {
                System.err.println("Error! Enter <input file> <output file> or \"help\"");
            }
            else
            {
                System.out.println("Usage:");
                System.out.println("the program selects triangles that are in 4 quarters");
                System.out.println("   enter <input file> <output file>");
                System.out.println("   enter \"help\" for reference");
            }
            return;
        }
        Triangle[] triangles = Utils.readArrayTrianglesFromFile(inputArgs.inputFile);
        Utils.writeTrianglesToFile(Logic.findTrianglesIn4Quarters(triangles), inputArgs.outputFile);
    }
}
