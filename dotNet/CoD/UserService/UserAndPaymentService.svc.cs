using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using CoD;

namespace UserService
{
    // REMARQUE : vous pouvez utiliser la commande Renommer du menu Refactoriser pour changer le nom de classe "UserAndPaymentService" à la fois dans le code, le fichier svc et le fichier de configuration.
    // REMARQUE : pour lancer le client test WCF afin de tester ce service, sélectionnez UserAndPaymentService.svc ou UserAndPaymentService.svc.cs dans l'Explorateur de solutions et démarrez le débogage.
    public class UserAndPaymentService : IUserAndPaymentService
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

        UserDAO userManager = new UserDAO();

        public void addUser(String email, String mdp)
        {
            userManager.addUser(email, mdp);
        }

        public bool isConnectionOK(String email, String mdp)
        {
            return userManager.isConnectionOK(email, mdp);
        }

        public string getListUsers()
        {
            string res = null;
            userManager.getListUsers().ForEach(delegate(User user)
            {
                res += user.ToString();
                res += '\n';
            });
            return res;
        }
    }
}
