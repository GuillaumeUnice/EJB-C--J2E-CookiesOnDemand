using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CoD;

namespace CoD_Client_Test
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(" ----- Test service ----- ");
            UserAndPaymentServiceReference.UserAndPaymentServiceClient userServiceStub = new UserAndPaymentServiceReference.UserAndPaymentServiceClient();
            Console.WriteLine(" ----- Test des utilisateurs ----- ");
            userServiceStub.addUser("francis.cabrel@gmail.com", "lacabane");
            userServiceStub.addUser("edouard.stark@gmail.com", "WinterIsComing");

            UserDAO userManager = new UserDAO();
            Console.WriteLine(userServiceStub.getListUsers());

            Console.WriteLine(userServiceStub.isConnectionOK("edouard.balladur@gmail.com", "WinterIsComing"));
            Console.WriteLine(userServiceStub.isConnectionOK("edouard.stark@gmail.com", "WinterIsComing"));
            Console.WriteLine(userServiceStub.isConnectionOK("edouard.stark@gmail.com", "lacabane"));

            Console.WriteLine(" ----- Test des Payments ----- ");
            PaymentServiceReference.PaymentServiceClient paymentServiceStub = new PaymentServiceReference.PaymentServiceClient();
            Console.WriteLine(paymentServiceStub.addPayment(12, "francis.cabrel@gmail.com", 101));
            Console.WriteLine(paymentServiceStub.addPayment(18, "francis.cabrel@gmail.com", 202));
            Console.WriteLine(paymentServiceStub.addPayment(23, "francis.cabrel@gmail.com", 201));
            Console.WriteLine(paymentServiceStub.addPayment(28, "francis.cabrel@gmail.com", 206));
            Console.WriteLine(paymentServiceStub.addPayment(15, userManager.getListUsers().ElementAt(0).Email, 102345));
            Console.WriteLine(paymentServiceStub.addPayment(12, userManager.getListUsers().ElementAt(0).Email, 22345678));

            PaymentDAO paymentManager = new PaymentDAO();
            Console.WriteLine(" ----- Toutes les factures ----- ");
            Console.WriteLine(paymentServiceStub.getListPayments());

            Console.WriteLine(" ----- Factures d'un user ----- ");
            Console.WriteLine(paymentServiceStub.getMyBills("francis.cabrel@gmail.com"));

            Console.WriteLine(" ----- Factures d'un user ----- ");
            Console.WriteLine(paymentServiceStub.getMyBills(userManager.getListUsers().ElementAt(0).Email));

        }
    }
}
