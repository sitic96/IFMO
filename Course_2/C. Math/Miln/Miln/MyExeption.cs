using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Miln
{
    public class StartAndEndSame : Exception
    {
        public StartAndEndSame() : base() { }
        public StartAndEndSame(string message, Exception innerException) : base(message, innerException) { }
    }
}
