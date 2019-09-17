using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RU_1016823
{
    class Program
    {
        static void Main(string[] args)
        {
        }
    }

    public class FilterLogic
    {
       
    }

    public class FilterNode
    {
        public string Name { get; }

        private List<FilterNode> _downLinks = new List<FilterNode>();
        private List<FilterNode> _upLinks = new List<FilterNode>();


    }

    
}
