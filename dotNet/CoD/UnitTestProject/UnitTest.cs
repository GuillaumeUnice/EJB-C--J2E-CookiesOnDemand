using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using CoD;

namespace UnitTestProject
{
    [TestClass]
    public class UnitTest
    {
        UserDAO userManager = new UserDAO();
        PaymentDAO paymentManager = new PaymentDAO();
        //UserServiceReference.UserServiceClient userServiceStub = new UserServiceReference.UserServiceClient();
        //PaymentServiceReference.PaymentServiceClient paymentServiceStub = new PaymentServiceReference.PaymentServiceClient();
        UserAndPaymentServiceReference.UserAndPaymentServiceClient userAndPaymentServiceStub = new UserAndPaymentServiceReference.UserAndPaymentServiceClient();

        [TestInitialize]
        public void init()
        {
            userAndPaymentServiceStub.addUser("francis.cabrel@gmail.com", "lacabane");
            userAndPaymentServiceStub.addUser("edouard.stark@gmail.com", "WinterIsComing");
        }
        [TestMethod]
        public void TestUser()
        {

            Assert.AreEqual(false, userAndPaymentServiceStub.isConnectionOK("edouard.balladur@gmail.com", "WinterIsComing"));
            Assert.AreEqual(true, userAndPaymentServiceStub.isConnectionOK("edouard.stark@gmail.com", "WinterIsComing"));
            Assert.AreEqual(false, userAndPaymentServiceStub.isConnectionOK("edouard.stark@gmail.com", "lacabane"));

        }

        [TestMethod]
        public void TestPayment()
        {

            Assert.AreEqual(false, userAndPaymentServiceStub.addPayment(12, "francis.cabrel@gmail.com", 101));
            Assert.AreEqual(true, userAndPaymentServiceStub.addPayment(18, "francis.cabrel@gmail.com", 202));
            Assert.AreEqual(false, userAndPaymentServiceStub.addPayment(23, "francis.cabrel@gmail.com", 201));
            Assert.AreEqual(true, userAndPaymentServiceStub.addPayment(28, "francis.cabrel@gmail.com", 206));
         
        }

    }
}
