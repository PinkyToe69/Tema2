package ro.mta.se.lab;

import org.mockito.Mock;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.testng.Assert.assertEquals;

/** clasa pentru testul mock
 *
 * @author  Comandasu Andrei
 */
public class OraseTestMock {

    private Orase orase;
    @Mock
    private OraseInterface mockedorase;
    @BeforeMethod
    public void beforeMethod(){
        mockedorase=mock(OraseInterface.class);
    }
    @AfterMethod
    public void afterMethod(){
        orase=null;
    }
    @DataProvider
    public Object[][] dp(){
        return new Object[][]{new Object[]{10,20,true},new Object[]{92,5,false},new Object[]{89,182,false},new Object[]{92,182,false}};

    }
    @Test(dataProvider = "dp")
    public void TestNormal(float lat,float lon,boolean value) throws Exception{

        when(mockedorase.getLat()).thenReturn(lat);
        when(mockedorase.getLon()).thenReturn(lon);
        orase=new Orase(mockedorase);
        orase.verifyValues();
        assertEquals(orase.isNormal(),value);
       for(int i=0;i<3;i++)
       {
           verify(mockedorase,times(1)).getLat();
           verify(mockedorase,times(1)).getLon();

       }

    }
}