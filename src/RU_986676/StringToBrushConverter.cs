using System;
using System.Globalization;
using System.Linq;
using System.Windows.Data;
using System.Windows.Media;

namespace RU_986676
{
    public class StringToBrushConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            var str = value as string;
            if (string.IsNullOrEmpty(str)) return new SolidColorBrush(Colors.White);
            var colors = typeof(Colors).GetProperties().ToDictionary(pi => pi.Name, co => (Color)co.GetValue(null));
            if (colors.ContainsKey(str)) return new SolidColorBrush(colors[str]);
            return new SolidColorBrush(Colors.White);
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}