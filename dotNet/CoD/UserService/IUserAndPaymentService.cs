using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace UserService
{
    // REMARQUE : vous pouvez utiliser la commande Renommer du menu Refactoriser pour changer le nom d'interface "IUserAndPaymentService" à la fois dans le code et le fichier de configuration.
    [ServiceContract]
    public interface IUserAndPaymentService
    {
        [OperationContract]
        void addUser(String email, String mdp);

        [OperationContract]
        bool isConnectionOK(String email, String mdp);

        [OperationContract]
        string getListUsers();

        [OperationContract]
        String getMyBills(String email);

        [OperationContract]
        Boolean addPayment(long id, String email, int cb);

        [OperationContract]
        string getListPayments();
    }
}
