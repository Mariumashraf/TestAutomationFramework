package levelset.tests;

import levelset.Wrappers.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {


   /* @Test
    public void testJSON() throws Exception {
        Assert.assertEquals(jsonReader.readData("PersonInformation"),"Marium");
    }*/

    @Test
    public void testdssg() throws Exception {
    Assert.assertEquals(new JsonReader(JsonReader.jsonFile)
            .getValueOfNode("Name").toString(),"Marium");
        Assert.assertEquals(new JsonReader(JsonReader.jsonFile)
                .getValueOfNode("MailContact/Password/Pass").toString(),"mrmr");
    }

    @Test
    public void testdsssg() throws Exception {
        Assert.assertEquals(new JsonReader(JsonReader.jsonFile)
                .getValueOf("MailContact","Email").get(0).toString(),"mero95");
        //Assert.assertEquals(jsonReader.getValueOfNode("MailContact/Password/Pass").toString(),"mrmr");
    }

}
