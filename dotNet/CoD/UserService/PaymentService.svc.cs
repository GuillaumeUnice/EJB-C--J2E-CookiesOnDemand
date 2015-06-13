using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using CoD;

namespace UserService
{
    // REMARQUE : vous pouvez utiliser la commande Renommer du menu Refactoriser pour changer le nom de classe "PaymentService" à la fois dans le code, le fichier svc et le fichier de configuration.
    // REMARQUE : pour lancer le client test WCF afin de tester ce service, sélectionnez PaymentService.svc ou PaymentService.svc.cs dans l'Explorateur de solutions et démarrez le débogage.
    public class PaymentService : IPaymentService
    {

        PaymentDAO paymentDAO = new PaymentDAO();

        public string getMyBills(String email)
        {
            string res = null;
            paymentDAO.getMyBills(email).ForEach(delegate(Payment payment)
            {
                res += payment.ToString();
                res += '\n';
            });
            return res;
        }

        public Boolean addPayment(long id, String email, int cb)
        {
            return paymentDAO.addPayment(id, email, cb);
        }


        public string getListPayments()
        {
            string res = null;
            paymentDAO.getListPayments().ForEach(delegate(Payment payment)
            {
                res += payment.ToString();
                res += '\n';
            });
            return res;
        }
    }
}
