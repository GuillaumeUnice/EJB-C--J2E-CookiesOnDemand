using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace CoD
{
    public class PaymentDAO
    {
        private static PaymentDAO instance;
        public static PaymentDAO Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new PaymentDAO();
                }
                return instance;
            }
        }
        /// <summary>
        /// Liste tous les payments
        /// </summary>
        public List<Payment> getListPayments()
        {
            using (CoDEntities modele = new CoDEntities())
            {
                var requete = from payment in modele.Payment
                              select payment;
                return requete.ToList<Payment>();
            }
        }

        /// <summary>
        /// Ajouter Payment
        /// </summary>
        public Boolean addPayment(long id, String user, int cb)
        {
            try
            {
                if (cb % 2 != 0) return false;
                using (CoDEntities modele = new CoDEntities())
                {
                    Payment payment = new Payment
                    {
                        IdCommande = id,
                        User = user
                    };
                    modele.Payment.Add(payment);
                    modele.SaveChanges();
                }
            }
            catch (Exception e) { }
            return true;
        }

        /// <summary>
        /// Ajouter Payment
        /// </summary>
        public Boolean addPayment(long id, User user, int cb)
        {
            try
            {
                if (cb % 2 != 0) return false;
                using (CoDEntities modele = new CoDEntities())
                {
                    Payment payment = new Payment
                    {
                        IdCommande = id,
                        User = user.Email
                    };
                    modele.Payment.Add(payment);
                    modele.SaveChanges();
                }
            }
            catch (Exception e) { }
            return true;
        }

        ///<summary>
        /// Retourne l'historique des factures d'un utilisateur
        /// </summary>
        public List<Payment> getMyBills(String user)
        {
            using (CoDEntities modele = new CoDEntities())
            {
                var requete = from payment in modele.Payment
                              where payment.User == user
                              select payment;
                return requete.ToList<Payment>();
            }
        }

        ///<summary>
        /// Retourne l'historique des factures d'un utilisateur
        /// </summary>
        public List<Payment> getMyBills(User user)
        {
            using (CoDEntities modele = new CoDEntities())
            {
                var requete = from payment in modele.Payment
                              where payment.User == user.Email
                              select payment;
                return requete.ToList<Payment>();
            }
        }
    }
}