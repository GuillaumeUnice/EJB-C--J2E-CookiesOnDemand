using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using CoD;

namespace UserService
{
    // REMARQUE : vous pouvez utiliser la commande Renommer du menu Refactoriser pour changer le nom de classe "UserService" à la fois dans le code, le fichier svc et le fichier de configuration.
    // REMARQUE : pour lancer le client test WCF afin de tester ce service, sélectionnez UserService.svc ou UserService.svc.cs dans l'Explorateur de solutions et démarrez le débogage.
    public class UserService : IUserService
    {
        UserDAO userManager = new UserDAO();

        public void addUser(String email, String mdp){
            userManager.addUser(email, mdp);
        }

        public bool isConnectionOK(String email, String mdp){
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
