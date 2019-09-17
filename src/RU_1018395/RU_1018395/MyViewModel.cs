using RU_1018395.Annotations;
using System;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Threading;
using System.Windows.Input;

namespace RU_1018395
{
    public class MyViewModel : INotifyPropertyChanged
    {
        public ICommand StartCommand { get; }
        public ICommand StopCommand { get; }


        private int _value;
        public int Value
        {
            get => _value;
            set
            {
                if (value == _value) return;
                _value = value;
                OnPropertyChanged();
            }
        }

        private Thread _thread;
        private CancellationTokenSource _tokenSource;

        public MyViewModel()
        {
            StartCommand = new DelegateCommand((p) =>
                {
                    _tokenSource = new CancellationTokenSource();
                    _thread = new Thread(Worker) { IsBackground = true };
                    _thread.Start(_tokenSource.Token);
                },
                p => _thread == null);

            StopCommand = new DelegateCommand(p =>
            {
                _tokenSource.Cancel();
                _tokenSource = null;
                _thread = null;
            }, p => _thread != null);
        }

        private void Worker(object state)
        {
            var token = (CancellationToken)state;
            while (!token.IsCancellationRequested)
            {
                Value++;
                Thread.Sleep(1000);
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        [NotifyPropertyChangedInvocator]
        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }

    public class DelegateCommand : ICommand
    {
        private readonly Action<object> _execute;
        private readonly Predicate<object> _canExecute;

        public DelegateCommand(Action<object> execute, Predicate<object> canExecute = null)
        {
            _execute = execute;
            _canExecute = canExecute;
        }

        public bool CanExecute(object parameter)
        {
            return _canExecute?.Invoke(parameter) ?? true;
        }


        public void Execute(object parameter)
        {
            _execute.Invoke(parameter);
        }

        public event EventHandler CanExecuteChanged
        {
            add => CommandManager.RequerySuggested += value;
            remove => CommandManager.RequerySuggested -= value;
        }
    }
}

