using RU_986676.Annotations;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace RU_986676
{
    public class MainViewModel : INotifyPropertyChanged
    {
        private string _viewModelText;

        public string ViewModelText
        {
            get => _viewModelText;
            set
            {
                if (value == _viewModelText) return;
                _viewModelText = value;
                OnPropertyChanged();
            }
        }


        public event PropertyChangedEventHandler PropertyChanged;

        [NotifyPropertyChangedInvocator]
        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}