package edu.uncoma.readJson;

/**
 * Created by aderenzis on 14/11/16.
 */

import java.io.File;
import java.io.IOException;

import edu.uncoma.tools.Utils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class Read_JSON
{
    public static void main(String[] args)
    {
        Utils.initializeDictionary();
        try
        {


            JsonParser parser = new JsonFactory().createJsonParser(new File("/home/aderenzis/Dropbox/SOA-Team/Papers/Microservices/Draft/schemaOrgTree.jsonld"));
            while (parser.nextToken() != JsonToken.NOT_AVAILABLE) {
                if ("name".equals(parser.getCurrentName())) {
                    parser.nextToken();
                    String value = parser.getText();
                   System.out.println(Utils.separarTerminosAuxFine(value));
                }
            }
            parser.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
